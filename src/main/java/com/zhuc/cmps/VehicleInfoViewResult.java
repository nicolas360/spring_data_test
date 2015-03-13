package com.zhuc.cmps;

import java.util.List;

/**
 * 
 * @title 		
 * @description 车辆配对关系同步	json返回
 * @usage		
 * @copyright	Copyright 2013  SHCMCT Corporation. All rights reserved.
 * @company		上海中移通信技术工程有限公司
 * @author		caixin
 * @create		2013-7-26 上午10:51:48
 */
public class VehicleInfoViewResult extends CmpsResult {

	private List<VehicleInfoView> vehicleInfoList;

	public List<VehicleInfoView> getVehicleInfoList() {
		return vehicleInfoList;
	}

	public void setVehicleInfoList(List<VehicleInfoView> vehicleInfoList) {
		this.vehicleInfoList = vehicleInfoList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VehicleInfoViewResult [vehicleInfoList=" + vehicleInfoList + ", isSuccess=" + isSuccess + ", errorMsg="
				+ errorMsg + "]";
	}

}
