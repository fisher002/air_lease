package com.air.lease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.lease.domain.User;

@Repository
public interface UserRepositorys extends JpaRepository<User,String> {

	public User findByUserid(String userid);
	
}
