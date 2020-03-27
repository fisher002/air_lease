package com.air.lease.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "air_detail_info")
public class AirConditionerDetailInfo {
	// 主键 用uuid 字符串 自动生成
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(name = "air_detail_id")
	private String airDetailId;

	// 空调Id（外键,对应AirConditioner）
	@Column(name = "air_id", nullable = false, length = 60)
	private String airId;

	// 空调名称
	@Column(name = "air_name", nullable = false, length = 255)
	private String airName;

	// 描述
	@Column(name = "air_describe", nullable = false, length = 255)
	private String airDescribe;

	// 提示
	@Column(name = "air_tips", nullable = false, length = 255)
	private String airTips;

	// 租金
	@Column(name = "air_rent", nullable = false, length = 60)
	private Integer airRent;

	// 押金
	@Column(name = "air_deposit", nullable = false, length = 60)
	private Integer airDeposit;

	// 库存
	@Column(name = "air_stock", nullable = false, length = 10)
	private Integer airStock;

	// 入库时间
	@Column(name = "air_put_date", nullable = false)
	private Date airPutDate;

	// 是否删除
	@Column(name = "isDelete", nullable = false)
	private Boolean isDelete;

	public String getAirDetailId() {
		return airDetailId;
	}

	public void setAirDetailId(String airDetailId) {
		this.airDetailId = airDetailId;
	}

	public String getAirId() {
		return airId;
	}

	public void setAirId(String airId) {
		this.airId = airId;
	}

	public String getAirName() {
		return airName;
	}

	public void setAirName(String airName) {
		this.airName = airName;
	}

	public String getAirDescribe() {
		return airDescribe;
	}

	public void setAirDescribe(String airDescribe) {
		this.airDescribe = airDescribe;
	}

	public String getAirTips() {
		return airTips;
	}

	public void setAirTips(String airTips) {
		this.airTips = airTips;
	}

	public Integer getAirRent() {
		return airRent;
	}

	public void setAirRent(Integer airRent) {
		this.airRent = airRent;
	}

	public Integer getAirDeposit() {
		return airDeposit;
	}

	public void setAirDeposit(Integer airDeposit) {
		this.airDeposit = airDeposit;
	}

	public Integer getAirStock() {
		return airStock;
	}

	public void setAirStock(Integer airStock) {
		this.airStock = airStock;
	}

	public Date getAirPutDate() {
		return airPutDate;
	}

	public void setAirPutDate(Date airPutDate) {
		this.airPutDate = airPutDate;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "AirConditionerDetailInfo [airDetailId=" + airDetailId + ", airId=" + airId + ", airName=" + airName
				+ ", airDescribe=" + airDescribe + ", airTips=" + airTips + ", airRent=" + airRent + ", airDeposit="
				+ airDeposit + ", airStock=" + airStock + ", airPutDate=" + airPutDate + ", isDelete=" + isDelete + "]";
	}

	public AirConditionerDetailInfo(String airDetailId, String airId, String airName, String airDescribe,
			String airTips, Integer airRent, Integer airDeposit, Integer airStock, Date airPutDate, Boolean isDelete) {
		super();
		this.airDetailId = airDetailId;
		this.airId = airId;
		this.airName = airName;
		this.airDescribe = airDescribe;
		this.airTips = airTips;
		this.airRent = airRent;
		this.airDeposit = airDeposit;
		this.airStock = airStock;
		this.airPutDate = airPutDate;
		this.isDelete = isDelete;
	}

	public AirConditionerDetailInfo() {

	}
}
