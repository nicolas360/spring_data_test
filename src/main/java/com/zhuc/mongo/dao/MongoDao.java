package com.zhuc.mongo.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @title 		抽象MongoDao
 * @description	
 * @usage		
 * @copyright	Copyright 2011  SHCMCT Corporation. All rights reserved.
 * @company		上海中移通信技术工程有限公司
 * @author		yaoqiang
 * @create		2013-8-16 下午4:36:23
 */
public abstract class MongoDao<T> {

	private static final Logger logger = LoggerFactory.getLogger(MongoDao.class);

	@Autowired
	private MongoTemplate mt;

	public void saveOrUpdate(T t) {
		mt.save(t);
	}

	public void save(T t) {
		mt.insert(t);
	}

	public void remove(T t) {
		mt.remove(t);
	}

	public void save(List<T> list) {
		if (!list.isEmpty()) {
			mt.insert(list, list.get(0).getClass());
		}
	}

	/**
	 * @return the mt
	 */
	public MongoTemplate getMt() {
		return mt;
	}

}