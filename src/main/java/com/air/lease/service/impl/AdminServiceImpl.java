package com.air.lease.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.air.lease.domain.Admin;
import com.air.lease.domain.ResultMsg;
import com.air.lease.repository.AdminRepository;
import com.air.lease.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	// 管理员列表
	@Override
	public Page<Admin> search(String keyword, int pageNumber) {
		// TODO 自动生成的方法存根
		Pageable pageable = PageRequest.of(pageNumber, 10);
		Page<Admin> page;
		if(StringUtils.isEmpty(keyword)) {
			page = this.adminRepository.findByIsDeleteFalse(pageable);
		}else {
			page = this.adminRepository.findByIsDeleteFalseAndAdminUserNameContaining(keyword, pageable);
		}
		return page;
	}
	// 删除管理员
	@Override
	public ResultMsg deleteAdminById(List<String> adminIds) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		List<Admin> admin = this.adminRepository.findAllById(adminIds);
		for(Admin ad:admin) {
			ad.setIsDelete(true);
		}
		if(this.adminRepository.saveAll(admin) != null) {
			msg.setCode(200);
			msg.setMessage("删除成功");
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("删除失败");
		return msg;
	}
	// 查询管理员
	@Override
	public ResultMsg findByAdminId(String adminId) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		Admin admin = this.adminRepository.findByAdminId(adminId);
		if(admin != null) {
			msg.setCode(200);;
			msg.setMessage("success");
			msg.setData(admin);
			return msg;
		}
		msg.setCode(500);;
		msg.setMessage("查询失败");
		return msg;
	}
	// 管理员新增/更新
	@Override
	public ResultMsg updateAdmin(Admin admin) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		if(this.adminRepository.findByAdminTellPhone(admin.getAdminTellPhone()) != null) {
			msg.setCode(500);
			msg.setMessage("操作失败，该手机号已注册，请更换！");
			return msg;
		}
		if(this.adminRepository.save(admin) != null) {
			msg.setCode(200);
			msg.setMessage("操作成功");
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("操作失败");
		return msg;
	}

}
