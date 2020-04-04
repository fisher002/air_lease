package com.air.lease.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "a_user")
public class Admin {
	// 系统管理员
	// 主键 用uuid 字符串 自动生成
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(name = "a_id")
	private String adminId;

	// 用户名(也可做为登录标识)
	@Column(name = "a_username", nullable = false, length = 60)
	private String adminUserName;

	// 用户密码
	@Column(name = "a_password", nullable = false, length = 60)
	private String adminPassWord;

	// 用户昵称
	@Column(name = "a_name", nullable = true, length = 60)
	private String adminName;

	// 用户电话号码(登录账号)
	@Column(name = "a_tellphone", nullable = false, length = 20)
	private String adminTellPhone;

	// 用户备注
	@Column(name = "a_remark", nullable = true, length = 120)
	private String adminRemark;

	// 用户注册时间
	@Column(name = "a_register_time", nullable = false, length = 60)
	private Date adminRegisterTime;

	// 用户状态(默认可用:available)
	@Column(name = "a_status", nullable = false, length = 60)
	private String adminStatus;
	
	// 是否删除
	@Column(name = "isDelete", nullable = false)
	private Boolean isDelete;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassWord() {
		return adminPassWord;
	}

	public void setAdminPassWord(String adminPassWord) {
		this.adminPassWord = adminPassWord;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminTellPhone() {
		return adminTellPhone;
	}

	public void setAdminTellPhone(String adminTellPhone) {
		this.adminTellPhone = adminTellPhone;
	}

	public String getAdminRemark() {
		return adminRemark;
	}

	public void setAdminRemark(String adminRemark) {
		this.adminRemark = adminRemark;
	}

	public Date getAdminRegisterTime() {
		return adminRegisterTime;
	}

	public void setAdminRegisterTime(Date adminRegisterTime) {
		this.adminRegisterTime = adminRegisterTime;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminUserName=" + adminUserName + ", adminPassWord=" + adminPassWord
				+ ", adminName=" + adminName + ", adminTellPhone=" + adminTellPhone + ", adminRemark=" + adminRemark
				+ ", adminRegisterTime=" + adminRegisterTime + ", adminStatus=" + adminStatus + ", isDelete=" + isDelete
				+ "]";
	}

	public Admin(String adminId, String adminUserName, String adminPassWord, String adminName, String adminTellPhone,
			String adminRemark, Date adminRegisterTime, String adminStatus, Boolean isDelete) {
		super();
		this.adminId = adminId;
		this.adminUserName = adminUserName;
		this.adminPassWord = adminPassWord;
		this.adminName = adminName;
		this.adminTellPhone = adminTellPhone;
		this.adminRemark = adminRemark;
		this.adminRegisterTime = adminRegisterTime;
		this.adminStatus = adminStatus;
		this.isDelete = isDelete;
	}

	public Admin() {
		
	}
	
}
