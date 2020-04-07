package com.air.lease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air.lease.domain.AirConditionerDetailInfo;
import com.air.lease.domain.LeaseInfo;
import com.air.lease.domain.ResultMsg;
import com.air.lease.domain.UserComment;
import com.air.lease.service.AirService;

@Controller
@RequestMapping(value = "/sk/air")
public class AirController {

	@Autowired
	private AirService airService;

	// 空调信息接口
	@PostMapping("/list")
	@ResponseBody
	public ResultMsg search(@RequestParam(name = "keyword", required = false) String keyword,
			// defaultValue没有此参数时，将页码强制设置为0，因为spring data里面的分页都是从0开始的
			@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {
		return this.airService.search(keyword, pageNumber);
	}

	@PostMapping("/find")
	@ResponseBody
	public AirConditionerDetailInfo findByairId(@RequestParam(name = "airId", required = true) String airId) {
		AirConditionerDetailInfo info = this.airService.findByAirId(airId);
		return info;
	}
	
	// 租赁信息接口
	@GetMapping("/lease/find")
	@ResponseBody
	public LeaseInfo findLeaseInfo(@RequestParam(name = "leaseId", required = true) String leaseId) {
		LeaseInfo info = this.airService.findByLeaseId(leaseId);
		return info;
	}
	
	@PostMapping("/lease/add")
	@ResponseBody
	public String addLeaseInfo(@RequestBody LeaseInfo info) {
		return this.airService.addLeaseInfo(info);
	}
	
	@PostMapping("/lease/delete")
	@ResponseBody
	public String delLeaseInfo(@RequestParam(name = "leaseId", required = true) String leaseId) {
		LeaseInfo info = this.airService.findByLeaseId(leaseId);
		info.setIsDelete(true);
		return this.airService.updateLeaseInfo(info);
	}
	
	@PostMapping("/lease/edit")
	@ResponseBody
	public String editLeaseInfo(@RequestBody LeaseInfo info) {
		return this.airService.updateLeaseInfo(info);
	}
	
	@GetMapping("/lease/info")
	@ResponseBody
	public ResultMsg searchInfo(
			// required 可不可为空 默认为true
			@RequestParam(name = "userId", required = false) String userId,
			// defaultValue没有此参数时，将页码强制设置为0，因为spring data里面的分页都是从0开始的
			@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {
		return this.airService.searchInfo(userId, pageNumber);
	}
	
	// 评论接口
	@PutMapping("/leasecomment/add")
	@ResponseBody
	public String addComment(@RequestBody UserComment comment) {
		return this.airService.addUserComment(comment);
	}
	
	@PostMapping("/leasecomment/list")
	@ResponseBody
	public ResultMsg findAllLeaseComment(@RequestParam(name = "airId", required = false) String airId,
			@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {
		return this.airService.findAllByairId(airId, pageNumber);
	}

}
