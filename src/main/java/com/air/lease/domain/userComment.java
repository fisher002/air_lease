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
public class userComment {

	// 主键 用uuid 字符串 自动生成
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(name = "comment_id")
	private String commentId;

	// 空调Id
	@Column(name = "air_id", nullable = false, length = 60)
	private String airId;

	// 租赁人Id/userId
	@Column(name = "u_id", nullable = false, length = 60)
	private String userId;
	
	// 评论内容
	@Column(name = "com_content", nullable = false)
	private String commentContent;
	
	// 评论时间
	@Column(name = "comment_date", nullable = false)
	private Date commentDate;
	
	// 是否删除
	@Column(name = "isDelete", nullable = false)
	private Boolean isDelete;

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
		return "userComment [commentId=" + commentId + ", airId=" + airId + ", userId=" + userId + ", commentContent="
				+ commentContent + ", commentDate=" + commentDate + ", isDelete=" + isDelete + "]";
	}

	public userComment(String commentId, String airId, String userId, String commentContent, Date commentDate,
			Boolean isDelete) {
		super();
		this.commentId = commentId;
		this.airId = airId;
		this.userId = userId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.isDelete = isDelete;
	}

	public userComment() {
		
	}

}
