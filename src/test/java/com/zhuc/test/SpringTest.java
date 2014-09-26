package com.zhuc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zhuc.common.utils.SpringContext;
import com.zhuc.mongo.dao.CommandDao;
import com.zhuc.mongo.entity.Command;
import com.zhuc.relation.dao.AirLineDao;
import com.zhuc.relation.entity.AirLine;
import com.zhuc.relation.entity.AirLinePK;
import com.zhuc.relation.service.CommonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class SpringTest {

	private static final Logger logger = LoggerFactory.getLogger(SpringTest.class);

	@Autowired
	private CommandDao commandDao;

	@Autowired
	private CommonService commonService;

	@Autowired
	private AirLineDao airLineDao;

	/**
	 * 推荐使用@Embeddable, 因为dao方法继承ID类, 使用spring data jpa更方便<br>
	 * 联合主键
	 */
	@Test
	public void lianhe() {
		AirLinePK pk = new AirLinePK();
		pk.setStartCity("Shanghai");
		pk.setEndCity("Beijing");

		AirLine airLine = new AirLine();
		airLine.setId(pk);
		airLine.setName("东方航空");

		//		commonService.saveAirLine(airLine);

		AirLine al = commonService.findAirLine(pk);
		System.out.println(JSON.toJSONString(al));
	}

	/**
	 * mongodb
	 */
	//	@Test
	public void t2() {
		commandDao.getMt().remove(new Query(), Command.class);

		Command c = new Command();
		c.setGserverId("5000001");
		c.setPlateNo("沪A213465");
		c.setSimcardNo("13467154545");
		c.setStatus(1);
		c.setUserName("15800466847");
		c.setContent("AT+GRVO=2,,,,0015$");
		commandDao.getMt().save(c);

		long count = commandDao.getMt().count(new Query(), Command.class);
		logger.debug("" + count);
	}

	/**
	 * 级联插入
	 * @throws Exception
	 */
	//	@Test
	public void t1() throws Exception {
		commonService.saveUser();
		commonService.cascadeUser();

		logger.debug("" + commandDao);
		logger.debug("" + SpringContext.getBean("commandDao"));
	}

}
