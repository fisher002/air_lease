package com.air.lease.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.lease.domain.User;
import com.air.lease.repository.UserRepositorys;
import com.air.lease.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositorys userRepositorys;
	
	@Override
	public User findById(String userid) {
		// TODO 自动生成的方法存根
		User user = this.userRepositorys.findByUserid(userid);
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
		User user = this.userRepositorys.findByUserid(userId);
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

}
