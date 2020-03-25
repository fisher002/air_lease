package com.air.lease.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User {
	
		// 普通用户
		// 主键 用uuid 字符串 自动生成
		@Id
		@GenericGenerator(name = "uuid2", strategy = "uuid2")
		@GeneratedValue(generator = "uuid2")
		@Column(name = "u_id")
		private String userid;
		// 用户名
		@Column(name = "username", nullable = false, length = 60)
		private String username;
		// 用户昵称
		@Column(name = "u_name", nullable = false, length = 60)
		private String name;
		// 密码
		@Column(name = "u_password", nullable = false, length = 60)
		private String password;
		// 电话
		@Column(name = "u_tellphone", nullable = false, length = 60)
		private String tellphone;
		// 年龄
		@Column(name = "u_age", nullable = false, length = 60)
		private String age;
		// 性别
		@Column(name = "u_sex", nullable = false, length = 60)
		private String sex;
		// 地址
		@Column(name = "u_address", nullable = false, length = 255)
		private String address;
		// qq
		@Column(name = "u_qq", nullable = true, length = 60)
		private String qq;
		// 邮箱
		@Column(name = "u_email", nullable = true, length = 120)
		private String email;
		// 类型
		@Column(name = "u_type", nullable = false, length = 60)
		private String type;
		// 注册时间
		@Column(name = "u_register_time", nullable = false, length = 255)
		private Date userRegisterTime;
		// 用户状态
		@Column(name = "u_status", nullable = false, length = 60)
		private String status;
		// 备注
		@Column(name = "u_remark", nullable = true, length = 255)
		private String remark;
		// 是否删除(逻辑删除)
		@Column(name = "isDelete", nullable = false, length = 60)
		private Boolean isDelete;
		public String getUserId() {
			return userid;
		}
		public void setUserId(String userId) {
			this.userid = userId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getTellphone() {
			return tellphone;
		}
		public void setTellphone(String tellphone) {
			this.tellphone = tellphone;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getQq() {
			return qq;
		}
		public void setQq(String qq) {
			this.qq = qq;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Date getUserRegisterTime() {
			return userRegisterTime;
		}
		public void setUserRegisterTime(Date userRegisterTime) {
			this.userRegisterTime = userRegisterTime;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public Boolean getIsDelete() {
			return isDelete;
		}
		public void setIsDelete(Boolean isDelete) {
			this.isDelete = isDelete;
		}
		public User(String userid, String username, String name, String password, String tellphone, String age,
				String sex, String address, String qq, String email, String type, Date userRegisterTime, String status,
				String remark, Boolean isDelete) {
			super();
			this.userid = userid;
			this.username = username;
			this.name = name;
			this.password = password;
			this.tellphone = tellphone;
			this.age = age;
			this.sex = sex;
			this.address = address;
			this.qq = qq;
			this.email = email;
			this.type = type;
			this.userRegisterTime = userRegisterTime;
			this.status = status;
			this.remark = remark;
			this.isDelete = isDelete;
		}
		@Override
		public String toString() {
			return "user [userid=" + userid + ", username=" + username + ", name=" + name + ", password=" + password
					+ ", tellphone=" + tellphone + ", age=" + age + ", sex=" + sex + ", address=" + address + ", qq="
					+ qq + ", email=" + email + ", type=" + type + ", userRegisterTime=" + userRegisterTime
					+ ", status=" + status + ", remark=" + remark + ", isDelete=" + isDelete + "]";
		}
		public User() {
			
		}
}
