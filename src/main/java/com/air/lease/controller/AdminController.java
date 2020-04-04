package com.air.lease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air.lease.domain.Admin;
import com.air.lease.domain.ResultMsg;
import com.air.lease.service.AdminService;

@Controller
@RequestMapping(value = "/am")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// 管理员接口
	// 获取管理员列表
	@GetMapping("/admin/list")
	@ResponseBody
	public ResultMsg search(@RequestParam(name = "keyword", required = false) String keyword,
			// defaultValue没有此参数时，将页码强制设置为0，因为spring data里面的分页都是从0开始的
			@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {
		Page<Admin> page = this.adminService.search(keyword, pageNumber);
		ResultMsg msg = new ResultMsg();
		if (page.getContent() != null) {
			msg.setCode(200);
			msg.setMessage("获取管理员列表成功");
			msg.setTotal(page.getTotalElements());
			msg.setData(page.getContent());
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("获取管理员列表失败");
		return msg;
	}

	// 获取单个管理员
	@GetMapping("/admin/get")
	@ResponseBody
	public ResultMsg findById(@RequestParam(name = "adminId", required = false) String adminId) {
		return this.adminService.findByAdminId(adminId);
	}

	// 新增/更新管理员
	@PutMapping("/admin/update")
	@ResponseBody
	public ResultMsg updateAdmin(@RequestBody Admin admin) {
		return this.adminService.updateAdmin(admin);
	}

	// 删除管理员(单个/多个)
	@PostMapping("/admin/delete")
	@ResponseBody
	public ResultMsg deleteAdminByIds(@RequestBody List<String> adminIds) {
		ResultMsg msg = this.adminService.deleteAdminById(adminIds);
		return msg;
	}

}
