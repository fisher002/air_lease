package com.air.lease.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.air.lease.domain.AirConditioner;
import com.air.lease.domain.AirConditionerDetailInfo;
import com.air.lease.domain.LeaseInfo;
import com.air.lease.repository.AirInfoRepository;
import com.air.lease.repository.AirRepository;
import com.air.lease.repository.LeaseInfoRepository;
import com.air.lease.service.AirService;

@Service
public class AirServiceImpl implements AirService {

	@Autowired
	private AirRepository airRepository;
	@Autowired
	private AirInfoRepository airInfoRepository;
	@Autowired
	private LeaseInfoRepository leaseInfoRepository;
	@Override
	public Page<AirConditioner> search(String keyword, int pageNumber) {
		// 封装分页条件 pageNumber:页码     10:每页最多10条数据
		Pageable pageable = PageRequest.of(pageNumber, 10);
		
		Page<AirConditioner> page;
		if(StringUtils.isEmpty(keyword)) {
			// 无关键字
			page = this.airRepository.findByIsDeleteFalse(pageable);
		} else {
			// 有关键字 Containing:前后模糊查询
			page = this.airRepository.findByIsDeleteFalseAndAirNameContaining(keyword, pageable);
		}
		return page;
	}
	// 空调详情
	@Override
	public AirConditionerDetailInfo findByAirId(String airId) {
		// TODO 自动生成的方法存根
		AirConditionerDetailInfo info = this.airInfoRepository.findByAirId(airId);
		return info;
	}
	
	// 查找空调
	@Override
	public AirConditioner findByairId(String airId) {
		// TODO 自动生成的方法存根
		AirConditioner air = this.airRepository.findByAirId(airId);
		return air;
	}
	
	// 新增租赁信息
	@Override
	public String addLeaseInfo(LeaseInfo info) {
		// TODO 自动生成的方法存根
		if(this.leaseInfoRepository.save(info) != null) {
			return "100000";
		}
		return "100001";
	}

}
