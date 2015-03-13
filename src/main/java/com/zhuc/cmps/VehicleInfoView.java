package com.zhuc.cmps;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: jichen
 * Date: 13-6-24
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */
public class VehicleInfoView {

	/**
	 * 车牌号码
	 */
	private String plateNo;

	/**
	 * SIM卡卡号
	 */
	private String cardNum;

	/**
	 * SIM卡串号
	 */
	private String serailnum;

	/**
	 * 设备串号（生产厂商代号+设备串号）
	 */
	private String eqNo;

	/**
	 *设备中心号码
	 */
	private String centerNo;

	/**
	 *设备质检号
	 */
	private String qualityNo;

	private Integer appId;

	private String gserverId;

	private Date overduetime;

	/**
	 * @return the plateNo
	 */
	public String getPlateNo() {
		return plateNo;
	}

	/**
	 * @return the cardNum
	 */
	public String getCardNum() {
		return cardNum;
	}

	/**
	 * @return the serailnum
	 */
	public String getSerailnum() {
		return serailnum;
	}

	/**
	 * @return the eqNo
	 */
	public String getEqNo() {
		return eqNo;
	}

	/**
	 * @return the centerNo
	 */
	public String getCenterNo() {
		return centerNo;
	}

	/**
	 * @return the qualityNo
	 */
	public String getQualityNo() {
		return qualityNo;
	}

	/**
	 * @return the appId
	 */
	public Integer getAppId() {
		return appId;
	}

	/**
	 * @return the gserverId
	 */
	public String getGserverId() {
		return gserverId;
	}

	/**
	 * @return the overduetime
	 */
	public Date getOverduetime() {
		return overduetime;
	}

	/**
	 * @param plateNo the plateNo to set
	 */
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	/**
	 * @param cardNum the cardNum to set
	 */
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	/**
	 * @param serailnum the serailnum to set
	 */
	public void setSerailnum(String serailnum) {
		this.serailnum = serailnum;
	}

	/**
	 * @param eqNo the eqNo to set
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	/**
	 * @param centerNo the centerNo to set
	 */
	public void setCenterNo(String centerNo) {
		this.centerNo = centerNo;
	}

	/**
	 * @param qualityNo the qualityNo to set
	 */
	public void setQualityNo(String qualityNo) {
		this.qualityNo = qualityNo;
	}

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	/**
	 * @param gserverId the gserverId to set
	 */
	public void setGserverId(String gserverId) {
		this.gserverId = gserverId;
	}

	/**
	 * @param overduetime the overduetime to set
	 */
	public void setOverduetime(Date overduetime) {
		this.overduetime = overduetime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VehicleInfoView [plateNo=" + plateNo + ", cardNum=" + cardNum + ", serailnum=" + serailnum + ", eqNo="
				+ eqNo + ", centerNo=" + centerNo + ", qualityNo=" + qualityNo + ", appId=" + appId + ", gserverId="
				+ gserverId + ", overduetime=" + overduetime + "]";
	}

}
