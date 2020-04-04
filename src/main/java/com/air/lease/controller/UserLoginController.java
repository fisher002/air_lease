package com.air.lease.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air.lease.domain.ResultMsg;
import com.air.lease.domain.User;
import com.air.lease.service.UserLoginService;

@Controller
@RequestMapping(value = "/sk")
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;

	// 注册
	@ResponseBody
	@PostMapping("/register/user")
	public ResultMsg registerUser(@RequestBody User request) {
		// 默认时间
		Date date = new Date();
		if (request.getUserRegisterTime() == null) {
			request.setUserRegisterTime(date);
		}
		return this.userLoginService.registerUser(request);
	}

	// 登录验证
	@ResponseBody
	@PostMapping("/login/user")
	public ResultMsg checkUserLogin(@RequestParam(name = "tellphone", required = true) String tellphone,
			@RequestParam(value = "password", required = true) String password) {
		return this.userLoginService.checkUserLogin(tellphone, password);
	}

}
