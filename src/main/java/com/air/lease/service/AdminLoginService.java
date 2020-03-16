package com.air.lease.service;

import com.air.lease.domain.Admin;

public interface AdminLoginService {
	
	public Admin checkLoginAdmin(String adminTellPhone,String adminPassWord);
	
}
