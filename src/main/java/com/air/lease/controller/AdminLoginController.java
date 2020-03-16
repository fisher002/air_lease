package com.air.lease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air.lease.domain.Admin;
import com.air.lease.service.AdminLoginService;

@Controller("adminLoginController")
@RequestMapping(value = "/sk")
public class AdminLoginController {

	@Autowired
	private AdminLoginService adminLoginService;
	
	@ResponseBody
	@PostMapping("/login/admin")
	public Admin checkAdminLogin(
			@RequestParam(name = "tellphone", required = true) String tellphone,
			@RequestParam(value = "password", required = true) String password) {
//		return "100000";
//		System.out.println("账号："+tellphone+" 密码："+password);
		Admin admin = this.adminLoginService.checkLoginAdmin(tellphone, password);
		if(admin == null) {
			return null;
		}else {
			admin.setAdminPassWord(null);
			return admin;
		}
	}
	
}
