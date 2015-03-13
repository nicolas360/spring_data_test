package com.zhuc.cmps;

import java.util.Map;

import com.zhuc.mongo.entity.Global;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

public class LocationCache {

	private static final Logger logger = LoggerFactory.getLogger(LocationCache.class);

	/**
	 * 缓存每辆车的全局信息,key为gserverId
	 */
	private static final Map<String, Global> globalMap = Maps.newConcurrentMap();

	public static void addToGlobalMap(String gserverId, Global global) {
		globalMap.put(gserverId, global);
	}

	public static Global removeFromGlobalMap(String gserverId) {
		Global g = null;
		if (null != gserverId) {
			g = globalMap.remove(gserverId);
		}
		return g;
	}

	public static Global getFromGlobalMap(String gserverId) {
		Global g = null;
		if (null != gserverId) {
			g = globalMap.get(gserverId);
		}
		return g;
	}

	public static Map<String, Global> getGlobalMap() {
		return globalMap;
	}

}
