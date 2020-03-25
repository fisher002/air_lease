package com.air.lease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air.lease.domain.User;
import com.air.lease.service.UserService;

@Controller
@RequestMapping( value = "/sk/user" )
public class UserController {

	@Autowired
	private UserService userService;
	@ResponseBody
	@PostMapping("/find")
	public User findById(@RequestParam(name = "userId",required = true)String userid) {
		User user = this.userService.findById(userid);
		return user == null ? null : user;
	}
	
	@ResponseBody
	@PatchMapping("/edit")
	public String updateUser(@RequestBody User user) {
		return this.userService.updateUser(user);
	}
	
	@ResponseBody
	@PostMapping("/editPassword")
	public String updateUserPassword(@RequestParam(name = "userId",required = true)String userId,
			@RequestParam(name = "oldPassword",required = true)String oldPassword,
			@RequestParam(name = "newPassword",required = true)String newPassword) {
		return this.userService.updateUserPassword(userId, oldPassword, newPassword);
	}
	
}
