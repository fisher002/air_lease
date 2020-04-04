package com.air.lease.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.lease.domain.ResultMsg;
import com.air.lease.domain.User;
import com.air.lease.repository.UserLoginRepository;
import com.air.lease.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@Override
	public ResultMsg checkUserLogin(String tellphone, String password) {
		// TODO 自动生成的方法存根 登录验证
		ResultMsg msg = new ResultMsg();
		User user = this.userLoginRepository.findByTellphoneAndPassword(tellphone, password);
		if(user != null) {
			msg.setCode(200);
			msg.setMessage("登录成功");
			msg.setData(user);
			return msg;
		}else {
			msg.setCode(500);
			msg.setMessage("账号或密码错误");
			return msg;
		}
	}

	@Override
	public ResultMsg registerUser(User user) {
		// TODO 自动生成的方法存根 用户注册
		ResultMsg msg = new ResultMsg();
		if(this.userLoginRepository.findByTellphoneAndIsDeleteFalse(user.getTellphone()) != null) {
			msg.setCode(500);
			msg.setMessage("该手机号已注册，请更换！");
			return msg;
		}
		if(this.userLoginRepository.save(user) != null) {
			msg.setCode(200);
			msg.setMessage("注册成功");
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("注册失败");
		return msg;
	}

}
