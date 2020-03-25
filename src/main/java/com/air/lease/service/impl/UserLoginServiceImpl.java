package com.air.lease.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.lease.domain.User;
import com.air.lease.repository.UserLoginRepository;
import com.air.lease.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@Override
	public User checkUserLogin(String tellphone, String password) {
		// TODO 自动生成的方法存根 登录验证
		User user = this.userLoginRepository.findByTellphoneAndPassword(tellphone, password);
		if(user != null) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	public String registerUser(User user) {
		// TODO 自动生成的方法存根 用户注册
		if(this.userLoginRepository.save(user) != null) {
			return "success";
		}
		return "fail";
	}

}
