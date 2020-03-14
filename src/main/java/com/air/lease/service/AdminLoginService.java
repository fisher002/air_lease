package com.air.lease.service;

import com.air.lease.domain.Admin;

public interface AdminLoginService {
	
	public Admin checkLogin(String adminTellPhone,String adminPassWord);
	
}
