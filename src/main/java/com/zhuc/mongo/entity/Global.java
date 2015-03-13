package com.zhuc.mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @title 		全局对象表, 管理车机及状态
 * @description	用于报表
 * @usage		
 * @copyright	Copyright 2011  SHCMCT Corporation. All rights reserved.
 * @company		上海中移通信技术工程有限公司
 * @author		yaoqiang
 * @create		2013-8-20 上午10:02:23
 */
@Document(collection = "global")
public class Global {

	private ObjectId _id;

	/**
	 * 车机设备号
	 */
	@Indexed
	private String devId;

	/**
	 * 上次回场后的里程数(千米)
	 */
	private Double mileage;

	/**
	 * 出车及回场标志位  1/0  1代表出车 0代表回场
	 */
	private Integer goAndCome;

	/**
	 * ACC点火时间
	 */
	private long accTime;

	/**
	 * 车机上报时间
	 */
	private long lastTime;

	/**
	 * 系统入库时间
	 */
	private long systemTime;

	/**
	 * 车辆抛锚  1/0   发生/未发生
	 */
	private Integer broken = 0;

	/**
	 * 车辆事故  1/0   发生/未发生
	 */
	private Integer accident = 0;

	/**
	 * 夜间停放  1/0   发生/未发生
	 */
	private Integer night = 0;

	/**
	 * 
	 */
	private String gserverId;

	/**
	 * @return the devId
	 */
	public String getDevId() {
		return devId;
	}

	/**
	 * @return the mileage
	 */
	public Double getMileage() {
		return mileage;
	}

	/**
	 * @return the goAndCome
	 */
	public Integer getGoAndCome() {
		return goAndCome;
	}

	/**
	 * @return the accTime
	 */
	public long getAccTime() {
		return accTime;
	}

	/**
	 * @return the lastTime
	 */
	public long getLastTime() {
		return lastTime;
	}

	/**
	 * @return the broken
	 */
	public Integer getBroken() {
		return broken;
	}

	/**
	 * @return the accident
	 */
	public Integer getAccident() {
		return accident;
	}

	/**
	 * @return the night
	 */
	public Integer getNight() {
		return night;
	}

	/**
	 * @return the gserverId
	 */
	public String getGserverId() {
		return gserverId;
	}

	/**
	 * @param devId the devId to set
	 */
	public void setDevId(String devId) {
		this.devId = devId;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	/**
	 * @param goAndCome the goAndCome to set
	 */
	public void setGoAndCome(Integer goAndCome) {
		this.goAndCome = goAndCome;
	}

	/**
	 * @param accTime the accTime to set
	 */
	public void setAccTime(long accTime) {
		this.accTime = accTime;
	}

	/**
	 * @param lastTime the lastTime to set
	 */
	public void setLastTime(long lastTime) {
		this.lastTime = lastTime;
	}

	/**
	 * @param broken the broken to set
	 */
	public void setBroken(Integer broken) {
		this.broken = broken;
	}

	/**
	 * @param accident the accident to set
	 */
	public void setAccident(Integer accident) {
		this.accident = accident;
	}

	/**
	 * @param night the night to set
	 */
	public void setNight(Integer night) {
		this.night = night;
	}

	/**
	 * @param gserverId the gserverId to set
	 */
	public void setGserverId(String gserverId) {
		this.gserverId = gserverId;
	}

	/**
	 * @return the _id
	 */
	public ObjectId get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	/**
	 * @return the systemTime
	 */
	public long getSystemTime() {
		return systemTime;
	}

	/**
	 * @param systemTime the systemTime to set
	 */
	public void setSystemTime(long systemTime) {
		this.systemTime = systemTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Global [_id=" + _id + ", devId=" + devId + ", mileage=" + mileage + ", goAndCome=" + goAndCome
				+ ", accTime=" + accTime + ", lastTime=" + lastTime + ", systemTime=" + systemTime + ", broken="
				+ broken + ", accident=" + accident + ", night=" + night + ", gserverId=" + gserverId + "]";
	}

}
