/**
 * 
 */
package com.zhuc.mongo.dao;


import com.zhuc.mongo.entity.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


/**
 * @title 		
 * @description	用于mongodb 位置信息查询
 * @usage		
 * @copyright	Copyright 2011  SHCMCT Corporation. All rights reserved.
 * @company		上海中移通信技术工程有限公司
 * @author		zhucheng
 * @create		2013-8-6 下午1:31:17
 */

@Repository("locationDao")
public class LocationDao extends MongoDao<Location> {

	private static final Logger logger = LoggerFactory.getLogger(LocationDao.class);

	private static final String COLLECTION_NAME = "location";

    /**
     * 获取最新一条位置信息(经纬度可为0)
     * @param gserverId
     * @return
     */
	public Location findLastLocationIgonre0(String gserverId) {
		Location location = getMt().findOne(new Query().addCriteria(Criteria.where("gserverId").is(gserverId))
                .with(new Sort(Direction.DESC, "reportTime")), Location.class);
		return location;
	}

}
