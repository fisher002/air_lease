package com.air.lease.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_comment")
public class UserComment {

	// 主键 用uuid 字符串 自动生成
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(name = "comment_id")
	private String commentId;

	// 空调Id
	@Column(name = "air_id", nullable = false, length = 60)
	private String airId;

	// 空调名称
	@Column(name = "air_name", nullable = false, length = 255)
	private String airName;

	// 租赁人Id/userId
	@Column(name = "u_id", nullable = false, length = 60)
	private String userId;

	// 租赁人姓名
	@Column(name = "username", nullable = false, length = 60)
	private String username;

	// 评论内容
	@Column(name = "com_content", nullable = false)
	private String commentContent;

	// 评论时间
	@Column(name = "comment_date", nullable = false)
	private Date commentDate;

	// 是否删除
	@Column(name = "isDelete", nullable = false)
	private Boolean isDelete;

	public String getAirName() {
		return airName;
	}

	public void setAirName(String airName) {
		this.airName = airName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getAirId() {
		return airId;
	}

	public void setAirId(String airId) {
		this.airId = airId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "UserComment [commentId=" + commentId + ", airId=" + airId + ", airName=" + airName + ", userId="
				+ userId + ", username=" + username + ", commentContent=" + commentContent + ", commentDate="
				+ commentDate + ", isDelete=" + isDelete + "]";
	}

	public UserComment(String commentId, String airId, String airName, String userId, String username,
			String commentContent, Date commentDate, Boolean isDelete) {
		super();
		this.commentId = commentId;
		this.airId = airId;
		this.airName = airName;
		this.userId = userId;
		this.username = username;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.isDelete = isDelete;
	}

	public UserComment() {

	}

}
