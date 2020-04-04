package com.air.lease.service;

import com.air.lease.domain.ResultMsg;
import com.air.lease.domain.User;

public interface UserLoginService {
	
	public ResultMsg checkUserLogin(String tellphone, String password);
	
	public ResultMsg registerUser(User user);

}
