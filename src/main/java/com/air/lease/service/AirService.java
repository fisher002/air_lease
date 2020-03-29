package com.air.lease.service;

import org.springframework.data.domain.Page;

import com.air.lease.domain.AirConditioner;
import com.air.lease.domain.AirConditionerDetailInfo;
import com.air.lease.domain.LeaseInfo;

public interface AirService {
	
	public Page<AirConditioner> search(String keyword, int pageNumber);
	
	AirConditionerDetailInfo findByAirId(String airId);
	
	AirConditioner findByairId(String airId);
	
	String addLeaseInfo(LeaseInfo info);
	
	Page<LeaseInfo> searchInfo(String userId, int pageNumber);
	
	String updateLeaseInfo(LeaseInfo info);
	
	LeaseInfo findByLeaseId(String leaseId);

}
