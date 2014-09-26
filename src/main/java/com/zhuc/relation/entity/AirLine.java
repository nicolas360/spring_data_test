package com.zhuc.relation.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_AIRLINE")
public class AirLine {

	@EmbeddedId
	//这个注解用于标注id这个属性为实体的标识符，因为我们使用的是复合主键类，所以我们要用@EmbeddedId这个专门针对复合主键类的标志实体标识符的注解。
	private AirLinePK id;

	@Column(length = 20)
	private String name;

	public AirLinePK getId() {
		return id;
	}

	public void setId(AirLinePK id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}