package com.zhuc.mongo.entity;

import org.bson.types.ObjectId;

public class MongoModel {

	private ObjectId _id;

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

}
