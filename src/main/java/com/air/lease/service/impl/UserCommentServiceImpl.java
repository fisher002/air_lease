package com.air.lease.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.air.lease.domain.ResultMsg;
import com.air.lease.domain.UserComment;
import com.air.lease.repository.UserCommentRepository;
import com.air.lease.repository.UserRepositorys;
import com.air.lease.service.UserCommentService;

@Service
public class UserCommentServiceImpl implements UserCommentService {
	@Autowired
	private UserCommentRepository commentRepository;
	@Autowired UserRepositorys userRepositorys;
	
	@Override
	public ResultMsg searchUserComment(String airName, int pageNumber) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		Pageable pageable = PageRequest.of(pageNumber, 10);
		Page<UserComment> page;
		if(StringUtils.isEmpty(airName)) {
			page = this.commentRepository.findByIsDeleteFalse(pageable);
			msg.setCode(200);
			msg.setMessage("获取用户评论列表成功");
			msg.setTotal(page.getTotalElements());
			msg.setData(page.getContent());
			return msg;
		}else {
			page = this.commentRepository.findByIsDeleteFalseAndAirNameContaining(airName, pageable);
			msg.setCode(200);
			msg.setMessage("获取用户评论列表成功");
			msg.setTotal(page.getTotalElements());
			msg.setData(page.getContent());
			return msg;
		}
	}

	@Override
	public ResultMsg findUserCommentById(String commentId) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		UserComment com = this.commentRepository.findByCommentIdAndIsDeleteFalse(commentId);
		if(com != null) {
			msg.setCode(200);
			msg.setMessage("获取用户评论成功");
			msg.setData(com);
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("获取用户评论失败");
		return msg;
	}

	@Override
	public ResultMsg deleteUserComments(List<String> commentIds) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		List<UserComment> list = this.commentRepository.findAllById(commentIds);
		if(list.size() > 0) {
			for(UserComment user : list) {
				user.setIsDelete(true);
			}
			this.commentRepository.saveAll(list);
			msg.setCode(200);
			msg.setMessage("删除成功");
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("删除失败");
		return msg;
	}

	@Override
	public ResultMsg updateUserComment(UserComment com) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		if(this.commentRepository.save(com) != null) {
			msg.setCode(200);
			msg.setMessage("操作成功");
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("操作失败");
		return msg;
	}

}
