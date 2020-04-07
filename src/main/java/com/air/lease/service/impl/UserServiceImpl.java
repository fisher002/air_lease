package com.air.lease.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.air.lease.domain.ResultMsg;
import com.air.lease.domain.User;
import com.air.lease.repository.UserRepositorys;
import com.air.lease.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositorys userRepositorys;
	
	@Override
	public User findById(String userId) {
		// TODO 自动生成的方法存根
		User user = this.userRepositorys.findByUserId(userId);
		return user == null ? null : user;
	}

	@Override
	public String updateUser(User user) {
		// TODO 自动生成的方法存根
		if(this.userRepositorys.save(user) != null) {
			return "100000";
		}
		return "100001";
	}

	@Override
	public String updateUserPassword(String userId, String oldPassword, String newPassword) {
		// TODO 自动生成的方法存根
		User user = this.userRepositorys.findByUserId(userId);
		if(user == null) {
			return "error";
		}
		if(oldPassword.equals(user.getPassword())) {
			user.setPassword(newPassword);
			this.userRepositorys.save(user);
			return "100000";
		} else {
			return "100001";
		}
	}
	
	// 获取用户列表
	@Override
	public ResultMsg search(String keyword, int pageNumber) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		Pageable pageable = PageRequest.of(pageNumber, 10);
		Page<User> page;
		if(StringUtils.isEmpty(keyword)) {
			page = this.userRepositorys.findByIsDeleteFalse(pageable);
			msg.setCode(200);
			msg.setMessage("获取用户数据成功");
			msg.setData(page.getContent());
			msg.setTotal(page.getTotalElements());
			return msg;
		}else {
			page = this.userRepositorys.findByIsDeleteFalseAndUsernameContaining(keyword,pageable);
			msg.setCode(200);
			msg.setMessage("获取用户数据成功");
			msg.setData(page.getContent());
			msg.setTotal(page.getTotalElements());
			return msg;
		}
	}

	// 获取用户
	@Override
	public ResultMsg findUserById(String userId) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		User user = this.userRepositorys.findByUserId(userId);
		if(user != null) {
			msg.setCode(200);
			msg.setMessage("获取用户数据成功");
			msg.setData(user);
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("获取用户数据失败");
		return msg;
	}

	// 删除用户（多个/单个）
	@Override
	public ResultMsg deleteUserById(List<String> userIds) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		List<User> users = this.userRepositorys.findAllById(userIds);
		for(User user : users) {
			user.setIsDelete(true);
		}
		if(this.userRepositorys.saveAll(users) != null) {
			msg.setCode(200);
			msg.setMessage("删除成功");
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("删除失败");
		return msg;
	}

	// 更新/新增用户
	@Override
	public ResultMsg updateUsers(User user) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		if(this.userRepositorys.save(user) != null) {
			msg.setCode(200);
			msg.setMessage("操作成功");
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("操作失败");
		return msg;
	}

}
