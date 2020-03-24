package com.air.lease.service;

import com.air.lease.domain.User;

public interface UserService {

	public User findById(String userid);
	
	public String updateUser(User user);
	
	public String updateUserPassword(String userId, String oldPassword, String newPassword);
	
}
