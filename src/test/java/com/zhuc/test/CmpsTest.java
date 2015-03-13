package com.zhuc.test;

import java.util.List;
import java.util.Set;

import com.zhuc.cmps.CmpsClient;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zhuc.cmps.CmpsCache;
import com.zhuc.cmps.VehicleInfoQuery;
import com.zhuc.mongo.dao.LastLocationDao;
import com.zhuc.mongo.dao.LocationDao;
import com.zhuc.mongo.entity.LastLocation;
import com.zhuc.mongo.entity.Location;

/**
 * Created by ZHUC on 2015/3/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class CmpsTest {

	private static final Logger logger = LoggerFactory.getLogger(CmpsTest.class);

	@Autowired
	private LocationDao locationDao;

	@Autowired
	private LastLocationDao lastLocationDao;

	@Test
	public void im() {
		logger.debug("开始定时从业务管理平台获取配对关系");

		try {
			VehicleInfoQuery query = new VehicleInfoQuery();
			query.setAppId(10000);
			CmpsClient.getVehicleInfo(query);

			List<LastLocation> list = Lists.newArrayList();
			Set<String> gserverIds = CmpsCache.getGserverIds();

			int i = 1;
			for (String id : gserverIds) {
				long temp = System.currentTimeMillis();
				logger.debug("查询第{}个{}", new Object[] { i, id });
				Location l = locationDao.findLastLocationIgonre0(id);
				logger.debug("查询第{}个{}结束, 用时{}秒",
						new Object[] { i++, id, (System.currentTimeMillis() - temp) / 1000.0 });

				LastLocation ll = null;
				//				String json = JSON.toJSONString(l);
				//				LastLocation ll = JSON.parseObject(json, LastLocation.class);
				if (null != l) {
					ll = new LastLocation();
					try {
						BeanUtils.copyProperties(ll, l);

						list.add(ll);
					} catch (Exception e) {
						logger.error("", e);
					}
				}

			}

			lastLocationDao.getMt().remove(new Query(), LastLocation.class);
			System.out.println(JSON.toJSONString(list));
			lastLocationDao.save(list);
			//			LastLocation ll = new LastLocation();
			//			lastLocationDao.saveOrUpdate(ll);

			logger.debug("全局信息缓存更新成功");

		} catch (Exception e) {
			logger.error("获取配对关系异常", e);
		}

		logger.debug("获取结束!");
	}
}
