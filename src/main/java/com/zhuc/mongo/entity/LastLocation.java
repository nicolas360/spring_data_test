package com.zhuc.mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zhuc.Constant;

/**
 * 只保存每辆车最新的位置记录
 */
@Document(collection = "lastlocation")
public class LastLocation {

	private ObjectId _id;

	/**
	 * ID
	 */
	private long locationId;

	/**
	 * 车辆流水号
	 */
	@Indexed
	private String gserverId = "";

	/**
	 * 车牌号码
	 */
	private String plateNo = "";

	/**
	 * 设备名称
	 */
	private String equipmentName = "";

	/**
	 * SIM卡号
	 */
	private String simcardNo = "";

	/**
	 * 上报时间(毫秒数)
	 */
	private long reportTime;

	/**
	 * 系统时间(毫秒数)
	 */
	private long currentTime;

	/**
	 * 方向
	 */
	private Integer direction;

	/**
	 * 速度
	 */
	private Double speed;

	/**
	 * 车辆状态
	 */
	private Integer status;

	/**
	 * 经度(高德纠偏后)
	 */
	private Double longitude;

	/**
	 * 纬度(高德纠偏后)
	 */
	private Double latitude;

	/**
	 * 原始经度
	 */
	private Double gpsLongitude;

	/**
	 * 原始纬度
	 */
	private Double gpsLatitude;

	/**
	 * 定位方式 1/2 GPS定位/基站定位
	 */
	private Integer type = Constant.POSITION_TYPE_GPS;

	/**
	 * 海拔高度
	 */
	private Double altitude;

	/**
	 * 位置
	 */
	private String location = "";

	//里程(千米)
	private Double mileage;

	/**
	 * MCC
	 */
	private Integer mcc = 0;

	/**
	 * MNC
	 */
	private Integer mnc = 0;

	/**
	 * lac
	 */
	private Integer lac = 0;

	/**
	 * cellid
	 */
	private Integer cellId = 0;

	/**
	 * @return the gpsLongitude
	 */
	public Double getGpsLongitude() {
		return gpsLongitude;
	}

	/**
	 * @return the gpsLatitude
	 */
	public Double getGpsLatitude() {
		return gpsLatitude;
	}

	/**
	 * @param gpsLongitude the gpsLongitude to set
	 */
	public void setGpsLongitude(Double gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}

	/**
	 * @param gpsLatitude the gpsLatitude to set
	 */
	public void setGpsLatitude(Double gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	/**
	 * @return the gserverId
	 */
	public String getGserverId() {
		return gserverId;
	}

	/**
	 * @return the plateNo
	 */
	public String getPlateNo() {
		return plateNo;
	}

	/**
	 * @return the simcardNo
	 */
	public String getSimcardNo() {
		return simcardNo;
	}

	/**
	 * @return the reportTime
	 */
	public long getReportTime() {
		return reportTime;
	}

	/**
	 * @return the direction
	 */
	public Integer getDirection() {
		return direction;
	}

	/**
	 * @return the speed
	 */
	public Double getSpeed() {
		return speed;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @return the altitude
	 */
	public Double getAltitude() {
		return altitude;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param gserverId the gserverId to set
	 */
	public void setGserverId(String gserverId) {
		this.gserverId = gserverId;
	}

	/**
	 * @param plateNo the plateNo to set
	 */
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	/**
	 * @param simcardNo the simcardNo to set
	 */
	public void setSimcardNo(String simcardNo) {
		this.simcardNo = simcardNo;
	}

	/**
	 * @param reportTime the reportTime to set
	 */
	public void setReportTime(long reportTime) {
		this.reportTime = reportTime;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @param altitude the altitude to set
	 */
	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the equipmentName
	 */
	public String getEquipmentName() {
		return equipmentName;
	}

	/**
	 * @param equipmentName the equipmentName to set
	 */
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	/**
	 * @return the mileage
	 */
	public Double getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	/**
	 * @return the locationId
	 */
	public long getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	/**
	 * @return the currentTime
	 */
	public long getCurrentTime() {
		return currentTime;
	}

	/**
	 * @param currentTime the currentTime to set
	 */
	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
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
	 * @return the mcc
	 */
	public Integer getMcc() {
		return mcc;
	}

	/**
	 * @return the mnc
	 */
	public Integer getMnc() {
		return mnc;
	}

	/**
	 * @param mcc the mcc to set
	 */
	public void setMcc(Integer mcc) {
		this.mcc = mcc;
	}

	/**
	 * @param mnc the mnc to set
	 */
	public void setMnc(Integer mnc) {
		this.mnc = mnc;
	}

	/**
	 * @return the lac
	 */
	public Integer getLac() {
		return lac;
	}

	/**
	 * @return the cellId
	 */
	public Integer getCellId() {
		return cellId;
	}

	/**
	 * @param lac the lac to set
	 */
	public void setLac(Integer lac) {
		this.lac = lac;
	}

	/**
	 * @param cellId the cellId to set
	 */
	public void setCellId(Integer cellId) {
		this.cellId = cellId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
