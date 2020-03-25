package com.air.lease.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String registerUser(@RequestBody User request) {
//		System.out.println(request);
		// 检测账号是否已经存在
		
		// 默认时间 状态 类型
		Date date = new Date();
		if(request.getUserRegisterTime() == null) {
			request.setUserRegisterTime(date);
		}
		request.setIsDelete(false);
		request.setStatus("available");
		request.setType("ordinary");
		String result = userLoginService.registerUser(request);
		if(result == "success") {
			return "ok";
		}
		return "fail";
	}
	
	// 登录验证
	@ResponseBody
	@PostMapping("/login/user")
	public User checkUserLogin(
			@RequestParam(name = "tellphone", required = true) String tellphone,
			@RequestParam(value = "password", required = true) String password) {
		User user = this.userLoginService.checkUserLogin(tellphone, password);
		// 密码加密再返回(未处理)
		return user == null ? null : user;
	}

}
