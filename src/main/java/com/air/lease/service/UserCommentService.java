package com.air.lease.service;

import java.util.List;

import com.air.lease.domain.ResultMsg;
import com.air.lease.domain.UserComment;

public interface UserCommentService {

	// 租赁信息(管理端)
	ResultMsg searchUserComment(String airName, int pageNumber);

	ResultMsg findUserCommentById(String commentId);

	ResultMsg deleteUserComments(List<String> commentIds);

	ResultMsg updateUserComment(UserComment com);

}
