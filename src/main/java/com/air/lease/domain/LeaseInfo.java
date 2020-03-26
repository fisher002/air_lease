package com.air.lease.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "air_lease_info")
public class LeaseInfo {

	// 主键 用uuid 字符串 自动生成
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(name = "lease_id")
	private String leaseId;

	// 空调Id
	@Column(name = "air_id", nullable = false, length = 60)
	private String airId;

	// 空调名称
	@Column(name = "air_name", nullable = false, length = 60)
	private String airName;

	// 租赁人Id/userId
	@Column(name = "u_id", nullable = false, length = 60)
	private String userId;

	// 租赁人姓名
	@Column(name = "username", nullable = false, length = 60)
	private String username;

	// 租赁开始时间
	@Column(name = "lease_start_date", nullable = false, length = 60)
	private Date leaseStartDate;

	// 租赁结束时间
	@Column(name = "lease_end_date", nullable = false, length = 60)
	private Date leaseEndDate;

	// 租赁空调台数
	@Column(name = "lease_number", nullable = false, length = 10)
	private Integer leaseNumber;

	// 租赁空调价格总和(押金+日租总和)
	@Column(name = "lease_price_sum", nullable = false, length = 10)
	private Integer leasePriceSum;

	// 操作时间
	@Column(name = "lease_edit_date", nullable = false, length = 60)
	private Date leaseEditDate;

	// 是否删除
	@Column(name = "isDelete", nullable = false)
	private Boolean isDelete;

	public String getLeaseId() {
		return leaseId;
	}

	public void setLeaseId(String leaseId) {
		this.leaseId = leaseId;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLeaseStartDate() {
		return leaseStartDate;
	}

	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}

	public Date getLeaseEndDate() {
		return leaseEndDate;
	}

	public void setLeaseEndDate(Date leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}

	public Integer getLeaseNumber() {
		return leaseNumber;
	}

	public void setLeaseNumber(Integer leaseNumber) {
		this.leaseNumber = leaseNumber;
	}

	public Integer getLeasePriceSum() {
		return leasePriceSum;
	}

	public void setLeasePriceSum(Integer leasePriceSum) {
		this.leasePriceSum = leasePriceSum;
	}

	public Date getLeaseEditDate() {
		return leaseEditDate;
	}

	public void setLeaseEditDate(Date leaseEditDate) {
		this.leaseEditDate = leaseEditDate;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "LeaseInfo [leaseId=" + leaseId + ", airId=" + airId + ", airName=" + airName + ", userId=" + userId
				+ ", username=" + username + ", leaseStartDate=" + leaseStartDate + ", leaseEndDate=" + leaseEndDate
				+ ", leaseNumber=" + leaseNumber + ", leasePriceSum=" + leasePriceSum + ", leaseEditDate="
				+ leaseEditDate + ", isDelete=" + isDelete + "]";
	}

	public LeaseInfo(String leaseId, String airId, String airName, String userId, String username, Date leaseStartDate,
			Date leaseEndDate, Integer leaseNumber, Integer leasePriceSum, Date leaseEditDate, Boolean isDelete) {
		super();
		this.leaseId = leaseId;
		this.airId = airId;
		this.airName = airName;
		this.userId = userId;
		this.username = username;
		this.leaseStartDate = leaseStartDate;
		this.leaseEndDate = leaseEndDate;
		this.leaseNumber = leaseNumber;
		this.leasePriceSum = leasePriceSum;
		this.leaseEditDate = leaseEditDate;
		this.isDelete = isDelete;
	}

	public LeaseInfo() {
		
	}

}
