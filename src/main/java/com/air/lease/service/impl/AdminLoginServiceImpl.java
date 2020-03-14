package com.air.lease.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.lease.domain.Admin;
import com.air.lease.repository.AdminLoginRepository;
import com.air.lease.service.AdminLoginService;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	
	@Autowired
	private AdminLoginRepository adminLoginRepository;
	@Override
	public Admin checkLogin(String adminTellPhone, String adminPassWord) {
		// TODO 自动生成的方法存根 可能存在空指针!!!
//		if("".equals(tellphone) && "".equals(password)) {
//			return;
//		}
		Admin admin = this.adminLoginRepository.findByAdminTellPhoneAndAdminPassWord(adminTellPhone, adminPassWord);
		return admin;
	}

}
