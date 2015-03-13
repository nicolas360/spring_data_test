package com.zhuc.cmps;

/**
 * 
 * @title 		
 * @description	
 * @usage		
 * @copyright	Copyright 2013  SHCMCT Corporation. All rights reserved.
 * @company		上海中移通信技术工程有限公司
 * @author		caixin
 * @create		2013-7-19 下午4:49:55
 */
public class VehicleInfoQuery {

	/**
	 * 应用系统ID
	 */
	private Integer appId;

	/**
	 * 车辆流水号
	 */
	private String gserverId;

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	/**
	 * @return the gserverId
	 */
	public String getGserverId() {
		return gserverId;
	}

	/**
	 * @param gserverId the gserverId to set
	 */
	public void setGserverId(String gserverId) {
		this.gserverId = gserverId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VehicleInfoQuery [appId=" + appId + ", gserverId=" + gserverId + "]";
	}

}
