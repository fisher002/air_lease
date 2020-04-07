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
import com.air.lease.domain.AirConditioner;
import com.air.lease.domain.AirConditionerDetailInfo;
import com.air.lease.domain.ResultMsg;
import com.air.lease.domain.User;
import com.air.lease.service.AdminService;
import com.air.lease.service.AirService;
import com.air.lease.service.UserService;

@Controller
@RequestMapping(value = "/am")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	@Autowired
	private AirService airService;

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

	// 管理用户接口
	// 获取用户列表
	@GetMapping("/admin/user/list")
	@ResponseBody
	public ResultMsg getUserList(@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {
		return this.userService.search(keyword, pageNumber);
	}

	// 获取单个用户
	@GetMapping("/admin/user/get")
	@ResponseBody
	public ResultMsg getUserById(@RequestParam(name = "userId", required = false) String userId) {
		return this.userService.findUserById(userId);
	}

	// 删除用户(单个/多个)
	@PostMapping("/admin/user/delete")
	@ResponseBody
	public ResultMsg deleteUserByIds(@RequestBody List<String> userIds) {
		return this.userService.deleteUserById(userIds);
	}

	// 更新/新增用户
	@PutMapping("/admin/user/update")
	@ResponseBody
	public ResultMsg updateUser(@RequestBody User user) {
		return this.userService.updateUsers(user);
	}

	// 管理空调接口
	// 获取空调列表
	@GetMapping("/admin/air/list")
	@ResponseBody
	public ResultMsg getAirList(@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {
		return this.airService.search(keyword, pageNumber);
	}

	// 获取单个空调信息
	@GetMapping("/admin/air/get")
	@ResponseBody
	public ResultMsg getAirById(@RequestParam(name = "airId", required = false) String airId) {
		return this.airService.findAirById(airId);
	}

	// 删除空调(单个/多个)
	@PostMapping("/admin/air/delete")
	@ResponseBody
	public ResultMsg deleteAirByIds(@RequestBody List<String> airIds) {
		return this.airService.deleteAirs(airIds);
	}

	// 更新/新增空调
	@PutMapping("/admin/air/update")
	@ResponseBody
	public ResultMsg updateAir(@RequestBody AirConditioner air) {
		return this.airService.updateAir(air);
	}

	// 获取空调ids
	@GetMapping("/admin/air/ids")
	@ResponseBody
	public ResultMsg airIds() {
		return this.airService.findAllAirIds();
	}
	@GetMapping("/admin/airinfo/ids")
	@ResponseBody
	public ResultMsg aieInfoIds() {
		return this.airService.findAllAirDetailAirIds();
	}
	
	// 管理空调详情接口
	// 获取空调详情列表
	@GetMapping("/admin/airdetail/list")
	@ResponseBody
	public ResultMsg getAirDetailList(@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {
		return this.airService.searchAirDetailInfo(keyword, pageNumber);
	}

	// 获取单个空调详情信息
	@GetMapping("/admin/airdetail/get")
	@ResponseBody
	public ResultMsg getAirDetailInfoById(@RequestParam(name = "airDetailId", required = false) String airDetailId) {
		return this.airService.getAirDetailInfo(airDetailId);
	}

	// 通过上级获取单个空调详情信息
	@GetMapping("/admin/airdetails/get")
	@ResponseBody
	public ResultMsg getAirDetailById(@RequestParam(name = "airId", required = false) String airId) {
		return this.airService.findAirDetailInfoById(airId);
	}

	// 删除空调详情(单个/多个)
	@PostMapping("/admin/airdetail/delete")
	@ResponseBody
	public ResultMsg deleteAirDetailByIds(@RequestBody List<String> airDetailIds) {
		return this.airService.deleteAirDetailInfos(airDetailIds);
	}

	// 更新/新增空调详情
	@PutMapping("/admin/airdetail/update")
	@ResponseBody
	public ResultMsg updateAirDetail(@RequestBody AirConditionerDetailInfo air) {
		return this.airService.updateAirDetailInfo(air);
	}

}
