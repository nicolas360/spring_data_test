package com.zhuc.mongo.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "command")
public class Command extends MongoModel {

	@Indexed
	private String gserverId;

	private String simcardNo;

	private String plateNo;

	private String content;

	private Integer status;

	private String userName;

	@Indexed
	private long createtime = System.currentTimeMillis();

	/**
	 * @return the gserverId
	 */
	public String getGserverId() {
		return gserverId;
	}

	/**
	 * @return the simcardNo
	 */
	public String getSimcardNo() {
		return simcardNo;
	}

	/**
	 * @return the plateNo
	 */
	public String getPlateNo() {
		return plateNo;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the createtime
	 */
	public long getCreatetime() {
		return createtime;
	}

	/**
	 * @param gserverId the gserverId to set
	 */
	public void setGserverId(String gserverId) {
		this.gserverId = gserverId;
	}

	/**
	 * @param simcardNo the simcardNo to set
	 */
	public void setSimcardNo(String simcardNo) {
		this.simcardNo = simcardNo;
	}

	/**
	 * @param plateNo the plateNo to set
	 */
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(long createtime) {
		this.createtime = createtime;
	}

}
