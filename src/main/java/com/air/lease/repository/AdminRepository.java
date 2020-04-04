package com.air.lease.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.lease.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

	Page<Admin> findByIsDeleteFalse(Pageable pageable);

	Page<Admin> findByIsDeleteFalseAndAdminUserNameContaining(String keyword, Pageable pageable);

	Admin findByAdminId(String adminId);

	Admin findByAdminTellPhone(String adminTellPhone);

}
