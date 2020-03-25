package com.air.lease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.lease.domain.Admin;

@Repository
public interface AdminLoginRepository extends JpaRepository<Admin, String>{
	
	// 检查账号存在与否
	public Admin findByAdminTellPhoneAndAdminPassWord(String adminTellPhone,String adminPassWord);
	
}
