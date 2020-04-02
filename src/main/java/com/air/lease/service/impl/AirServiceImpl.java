package com.air.lease.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.air.lease.domain.AirConditioner;
import com.air.lease.domain.AirConditionerDetailInfo;
import com.air.lease.domain.LeaseInfo;
import com.air.lease.domain.ResultMsg;
import com.air.lease.domain.User;
import com.air.lease.domain.UserComment;
import com.air.lease.domain.UserCommentMsg;
import com.air.lease.domain.UserMsg;
import com.air.lease.repository.AirInfoRepository;
import com.air.lease.repository.AirRepository;
import com.air.lease.repository.LeaseInfoRepository;
import com.air.lease.repository.UserCommentRepository;
import com.air.lease.repository.UserRepositorys;
import com.air.lease.service.AirService;

@Service
public class AirServiceImpl implements AirService {

	@Autowired
	private AirRepository airRepository;
	@Autowired
	private AirInfoRepository airInfoRepository;
	@Autowired
	private LeaseInfoRepository leaseInfoRepository;
	@Autowired
	private UserCommentRepository commentRepository;
	@Autowired
	private UserRepositorys userRepositorys;
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
	
	// 查询租赁记录
	@Override
	public Page<LeaseInfo> searchInfo(String userId, int pageNumber) {
		// TODO 自动生成的方法存根
		// 封装分页条件 pageNumber:页码
		Pageable pageable = PageRequest.of(pageNumber, 10);
		Page<LeaseInfo> page;;
		if(StringUtils.isEmpty(userId)) {
			page = this.leaseInfoRepository.findByIsDeleteFalse(pageable);
		}else {
			page = this.leaseInfoRepository.findByIsDeleteFalseAndUserId(userId, pageable);
		}
		return page;
	}
	
	// 更新租赁信息
	@Override
	public String updateLeaseInfo(LeaseInfo info) {
		// TODO 自动生成的方法存根
		if(this.leaseInfoRepository.save(info) != null) {
			return "100000";
		}
		return "100001";
	}
	
	// 通过id查询租赁信息
	@Override
	public LeaseInfo findByLeaseId(String leaseId) {
		// TODO 自动生成的方法存根
		return this.leaseInfoRepository.findByLeaseId(leaseId);
	}
	
	// 用户评论
	// 新增用户评论
	@Override
	public String addUserComment(UserComment comment) {
		// TODO 自动生成的方法存根
		return this.commentRepository.save(comment) != null ? "100000":"100001";
	}
	// 查询用户评论
	@Override
	public ResultMsg findAllByairId(String airId, int pageNumber) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		Pageable pageable = PageRequest.of(pageNumber, 10);
		Page<UserComment> page = this.commentRepository.findByAirIdAndIsDeleteFalse(airId, pageable);
		if(page.getContent() != null) {
			List<UserComment> list = page.getContent();
			// 存所有的组装信息
			List<Object> l = new ArrayList<Object>();
			for(UserComment u : list) {
				// 每一项
				UserCommentMsg m1 = new UserCommentMsg();
				// 组装的用户信息
				UserMsg m2 = new UserMsg();
				// 用户信息
				User user = this.userRepositorys.findByUserId(u.getUserId());
				m2.setName(user.getName());
				m2.setHeadPiuture(user.getHeadPicture());
				m1.setUserMessage(m2);
				m1.setUserComment(u);
				l.add(m1);
			}
			msg.setCode(200);
			msg.setMessage("success");
			msg.setData(l);
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("未知错误");
		return msg;
	}

}
