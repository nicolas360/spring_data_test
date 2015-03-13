package com.zhuc.mongo.dao;


import com.zhuc.mongo.entity.Global;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("globalDao")
public class GlobalDao extends MongoDao<Global> {

	private static final Logger logger = LoggerFactory.getLogger(GlobalDao.class);

	public List<Global> findAll() {
		return getMt().findAll(Global.class);
	}

	public List<Global> findByDevId(String devId) {
		return getMt().find(new Query(Criteria.where("devId").is(devId)), Global.class);
	}

    /**
     * 获取5分钟内活跃的车辆数
     * @return
     */
    public long getActiveCount(){
        long time = System.currentTimeMillis() - 5*60*1000l;
        return getMt().count(new Query(Criteria.where("systemTime").gt(time)), Global.class);
    }

}
