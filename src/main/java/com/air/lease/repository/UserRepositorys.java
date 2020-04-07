package com.air.lease.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.lease.domain.User;

@Repository
public interface UserRepositorys extends JpaRepository<User,String> {

	User findByUserId(String userId);

	Page<User> findByIsDeleteFalse(Pageable pageable);

	Page<User> findByIsDeleteFalseAndUsernameContaining(String keyword, Pageable pageable);
	
}
