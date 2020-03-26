package com.air.lease.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "air_conditioner")
public class AirConditioner {

	// 主键 用uuid 字符串 自动生成
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(name = "air_id")
	private String airId;

	// 类型
	@Column(name = "air_type", nullable = false, length = 60)
	private String airType;

	// 空调名称
	@Column(name = "air_name", nullable = false, length = 60)
	private String airName;

	// 型号
	@Column(name = "air_model", nullable = false, length = 255)
	private String airModel;

	// 图片
	@Column(name = "air_picture", nullable = false, length = 255)
	private String airPicture;

	// 是否删除
	@Column(name = "isDelete", nullable = false)
	private Boolean isDelete;

	public String getAirPicture() {
		return airPicture;
	}

	public void setAirPicture(String airPicture) {
		this.airPicture = airPicture;
	}

	public String getAirId() {
		return airId;
	}

	public void setAirId(String airTypeId) {
		this.airId = airTypeId;
	}

	public String getAirType() {
		return airType;
	}

	public void setAirType(String airType) {
		this.airType = airType;
	}

	public String getAirName() {
		return airName;
	}

	public void setAirName(String airName) {
		this.airName = airName;
	}

	public String getAirModel() {
		return airModel;
	}

	public void setAirModel(String airModel) {
		this.airModel = airModel;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "AirConditioner [airId=" + airId + ", airType=" + airType + ", airName=" + airName + ", airModel="
				+ airModel + ", airPicture=" + airPicture + ", isDelete=" + isDelete + "]";
	}

	public AirConditioner(String airId, String airType, String airName, String airModel, String airPicture,
			Boolean isDelete) {
		super();
		this.airId = airId;
		this.airType = airType;
		this.airName = airName;
		this.airModel = airModel;
		this.airPicture = airPicture;
		this.isDelete = isDelete;
	}

	public AirConditioner() {
		
	}

}
