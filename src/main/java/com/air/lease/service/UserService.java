package com.air.lease.service;

import java.util.List;

import com.air.lease.domain.ResultMsg;
import com.air.lease.domain.User;

public interface UserService {

	public User findById(String userId);
	
	public String updateUser(User user);
	
	public String updateUserPassword(String userId, String oldPassword, String newPassword);
	
	ResultMsg search(String keyword, int pageNumber);
	
	ResultMsg findUserById(String userId);

	ResultMsg deleteUserById(List<String> userIds);
	
	ResultMsg updateUsers(User user);
	
}
