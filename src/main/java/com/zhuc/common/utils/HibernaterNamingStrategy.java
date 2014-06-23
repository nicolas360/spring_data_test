package com.zhuc.common.utils;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.cfg.NamingStrategy;

/**
 * @title 		
 * @description	自定义hibernate生成表名命名规则，生成的所有表名全部大写，表名以"T" 开头
 * @usage		
 * @copyright	Copyright 2011  SHCMCT Corporation. All rights reserved.
 * @company		上海中移通信技术工程有限公司
 * @author		John.Yao
 * @create		2012-11-28 下午4:50:15
 */
public class HibernaterNamingStrategy extends ImprovedNamingStrategy implements NamingStrategy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6521189046655278L;

	@Override
	public String tableName(String tableName) {
		return addUnderscores(tableName).toUpperCase();
	}

	@Override
	public String classToTableName(String className) {
		String tn = tableName(className);
		if (!tn.startsWith("T_")) {
			return "T_" + tn;
		} else {
			return tn;
		}

	}

	@Override
	public String propertyToColumnName(String propertyName) {
		return addUnderscores(propertyName).toUpperCase();
	}
}
