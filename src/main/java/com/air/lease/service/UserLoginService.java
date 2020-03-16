package com.air.lease.service;

import com.air.lease.domain.User;

public interface UserLoginService {
	
	public User checkUserLogin(String tellphone, String password);
	
	public String registerUser(User user);

}
