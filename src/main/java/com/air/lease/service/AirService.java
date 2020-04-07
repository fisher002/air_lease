package com.air.lease.service;

import java.util.List;

import com.air.lease.domain.AirConditioner;
import com.air.lease.domain.AirConditionerDetailInfo;
import com.air.lease.domain.LeaseInfo;
import com.air.lease.domain.ResultMsg;
import com.air.lease.domain.UserComment;

public interface AirService {
	
	ResultMsg search(String keyword, int pageNumber); // 客户端/管理端空调列表

	AirConditionerDetailInfo findByAirId(String airId);// 客户端用户查询空调详情

	AirConditioner findByairId(String airId);

	String addLeaseInfo(LeaseInfo info); // 客户端租赁新增

	ResultMsg searchInfo(String userId, int pageNumber); // 客户端用户查询租赁信息列表

	String updateLeaseInfo(LeaseInfo info);// 客户端用户更新租赁信息

	LeaseInfo findByLeaseId(String leaseId);// 客户端用户查询租赁信息

	String addUserComment(UserComment comment); // 用户评论

	// 空调(管理端)
	ResultMsg findAllAirIds();
	
	ResultMsg findAllByairId(String airId, int pageNumber);

	ResultMsg findAirById(String airId);

	ResultMsg deleteAirs(List<String> airIds);

	ResultMsg updateAir(AirConditioner air);

	// 空调详情(管理端)
	ResultMsg findAllAirDetailAirIds();
	
	ResultMsg searchAirDetailInfo(String keyword, int pageNumber);

	ResultMsg findAirDetailInfoById(String airId);

	ResultMsg deleteAirDetailInfos(List<String> airDetailIds);

	ResultMsg updateAirDetailInfo(AirConditionerDetailInfo air);
	
	ResultMsg getAirDetailInfo(String airDetailId);

}
