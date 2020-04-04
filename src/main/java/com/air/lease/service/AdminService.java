package com.air.lease.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.air.lease.domain.Admin;
import com.air.lease.domain.ResultMsg;

public interface AdminService {
	Page<Admin> search(String keyword, int pageNumber);
	ResultMsg deleteAdminById(List<String> adminIds);
	ResultMsg findByAdminId(String adminId);
	ResultMsg updateAdmin(Admin admin);
}
