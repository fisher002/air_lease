package com.air.lease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.lease.domain.User;

@Repository
public interface UserLoginRepository extends JpaRepository<User,String> {
	
	// 检查账号存在与否
	public User findByTellphoneAndPassword(String tellphone, String password);

	public User findByTellphoneAndIsDeleteFalse(String tellphone);

}
