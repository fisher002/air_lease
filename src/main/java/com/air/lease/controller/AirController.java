package com.air.lease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.air.lease.domain.AirConditioner;
import com.air.lease.domain.AirConditionerDetailInfo;
import com.air.lease.domain.LeaseInfo;
import com.air.lease.service.AirService;

@Controller
@RequestMapping(value = "/sk/air")
public class AirController {

	@Autowired
	private AirService airService;

	@PostMapping("/list")
	@ResponseBody
	public List<AirConditioner> search(@RequestParam(name = "keyword", required = false) String keyword,
			// defaultValue没有此参数时，将页码强制设置为0，因为spring data里面的分页都是从0开始的
			@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {

		Page<AirConditioner> page = this.airService.search(keyword, pageNumber);
		List<AirConditioner> list = page.getContent();
		return list;

	}

	@PostMapping("/find")
	@ResponseBody
	public AirConditionerDetailInfo findByairId(@RequestParam(name = "airId", required = true) String airId) {

		AirConditionerDetailInfo info = this.airService.findByAirId(airId);
		return info;

	}
	
	@PostMapping("/lease/add")
	@ResponseBody
	public String addLeaseInfo(@RequestBody LeaseInfo info) {
		return this.airService.addLeaseInfo(info);
	}
	
	@GetMapping("/lease/info")
	@ResponseBody
	public List<LeaseInfo> searchInfo(
			// required 可不可为空 默认为true
			@RequestParam(name = "userId", required = false) String userId,
			// defaultValue没有此参数时，将页码强制设置为0，因为spring data里面的分页都是从0开始的
			@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {
		
		Page<LeaseInfo> page = this.airService.searchInfo(userId, pageNumber);
		List<LeaseInfo> list = page.getContent();
		return list;
	}

}
