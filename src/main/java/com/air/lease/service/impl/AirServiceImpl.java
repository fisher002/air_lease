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

	// 获取空调列表(管理端/客户端)
	@Override
	public ResultMsg search(String keyword, int pageNumber) {
		// 封装分页条件 pageNumber:页码 10:每页最多10条数据
		Pageable pageable = PageRequest.of(pageNumber, 10);
		ResultMsg msg = new ResultMsg();
		Page<AirConditioner> page;
		if (StringUtils.isEmpty(keyword)) {
			// 无关键字
			page = this.airRepository.findByIsDeleteFalse(pageable);
			msg.setCode(200);
			msg.setMessage("获取空调数据成功");
			msg.setData(page.getContent());
			msg.setTotal(page.getTotalElements());
			return msg;
		} else {
			// 有关键字 Containing:前后模糊查询
			page = this.airRepository.findByIsDeleteFalseAndAirNameContaining(keyword, pageable);
			msg.setCode(200);
			msg.setMessage("获取空调数据成功");
			msg.setData(page.getContent());
			msg.setTotal(page.getTotalElements());
			return msg;
		}
	}

	// 空调详情(客户端)
	@Override
	public AirConditionerDetailInfo findByAirId(String airId) {
		// TODO 自动生成的方法存根
		AirConditionerDetailInfo info = this.airInfoRepository.findByAirId(airId);
		return info;
	}

	// 获取未有详情的空调(客户端)
	@Override
	public ResultMsg findAllAir(List<String> airIds) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		List<AirConditioner> list = this.airRepository.findAllById(airIds);
		if (list.size() > 0) {
			msg.setCode(200);
			msg.setMessage("获取空调数据成功");
			msg.setData(list);
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("获取空调数据失败");
		return msg;
	}

	// 查找空调(管理端)
	@Override
	public ResultMsg findAirById(String airId) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		AirConditioner air = this.airRepository.findByAirId(airId);
		if (air != null) {
			msg.setCode(200);
			msg.setMessage("获取空调数据成功");
			msg.setData(air);
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("获取空调数据失败");
		return msg;
	}

	// 删除空调(管理端)
	@Override
	public ResultMsg deleteAirs(List<String> airIds) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		List<AirConditioner> list = this.airRepository.findAllById(airIds);
		for (AirConditioner air : list) {
			air.setIsDelete(true);
		}
		if (this.airRepository.saveAll(list) != null) {
			msg.setCode(200);
			msg.setMessage("删除成功");
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("删除失败");
		return msg;
	}

	// 更新/新增空调(管理端)
	@Override
	public ResultMsg updateAir(AirConditioner air) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		if (this.airRepository.save(air) != null) {
			msg.setCode(200);
			msg.setMessage("操作成功");
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("操作失败");
		return msg;
	}

	// 查找空调(客户端)
	@Override
	public AirConditioner findByairId(String airId) {
		// TODO 自动生成的方法存根
		AirConditioner air = this.airRepository.findByAirId(airId);
		return air;
	}

	// 新增租赁信息(客户端)
	@Override
	public String addLeaseInfo(LeaseInfo info) {
		// TODO 自动生成的方法存根
		if (this.leaseInfoRepository.save(info) != null) {
			return "100000";
		}
		return "100001";
	}

	// 查询租赁记录(客户端)
	@Override
	public ResultMsg searchInfo(String userId, int pageNumber) {
		// TODO 自动生成的方法存根
		// 封装分页条件 pageNumber:页码
		Pageable pageable = PageRequest.of(pageNumber, 10);
		Page<LeaseInfo> page;
		ResultMsg msg = new ResultMsg();
		if (StringUtils.isEmpty(userId)) {
			page = this.leaseInfoRepository.findByIsDeleteFalse(pageable);
			msg.setCode(200);
			msg.setMessage("获取租赁数据成功");
			msg.setData(page.getContent());
			msg.setTotal(page.getTotalElements());
			msg.setPages(page.getTotalPages());
			return msg;
		} else {
			page = this.leaseInfoRepository.findByIsDeleteFalseAndUserId(userId, pageable);
			msg.setCode(200);
			msg.setMessage("获取租赁数据成功");
			msg.setData(page.getContent());
			msg.setTotal(page.getTotalElements());
			msg.setPages(page.getTotalPages());
			return msg;
		}
	}

	// 更新租赁信息(客户端)
	@Override
	public String updateLeaseInfo(LeaseInfo info) {
		// TODO 自动生成的方法存根
		if (this.leaseInfoRepository.save(info) != null) {
			return "100000";
		}
		return "100001";
	}

	// 通过id查询租赁信息(客户端)
	@Override
	public LeaseInfo findByLeaseId(String leaseId) {
		// TODO 自动生成的方法存根
		return this.leaseInfoRepository.findByLeaseId(leaseId);
	}

	// 用户评论(客户端)
	// 新增用户评论(客户端)
	@Override
	public String addUserComment(UserComment comment) {
		// TODO 自动生成的方法存根
		return this.commentRepository.save(comment) != null ? "100000" : "100001";
	}

	// 查询用户评论(客户端)
	@Override
	public ResultMsg findAllByairId(String airId, int pageNumber) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		Pageable pageable = PageRequest.of(pageNumber, 10);
		Page<UserComment> page;
		if (StringUtils.isEmpty(airId)) {
			page = this.commentRepository.findByIsDeleteFalse(pageable);
			synchronized (page) {
				List<UserComment> list = page.getContent();
				// 存所有的组装信息
				List<Object> l = new ArrayList<Object>();
				for (UserComment u : list) {
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
				msg.setMessage("获取用户评论成功");
				msg.setTotal(page.getTotalElements());
				msg.setData(l);
				msg.setPages(page.getTotalPages());
				return msg;
			}
		} else {
			page = this.commentRepository.findByAirIdAndIsDeleteFalse(airId, pageable);
			synchronized (page) {
				if (page.getContent() != null) {
					List<UserComment> list = page.getContent();
					// 存所有的组装信息
					List<Object> l = new ArrayList<Object>();
					for (UserComment u : list) {
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
					msg.setMessage("获取用户评论成功");
					msg.setTotal(page.getTotalElements());
					msg.setData(l);
					msg.setPages(page.getTotalPages());
					return msg;
				}
				msg.setCode(500);
				msg.setMessage("获取用户评论失败");
				return msg;
			}
		}
	}

	@Override
	public ResultMsg findAllAirIds() {
		// TODO 自动生成的方法存根 查询所有空调ID
		ResultMsg msg = new ResultMsg();
		List<AirConditioner> airs = this.airRepository.findAllByIsDeleteFalse();
		List<String> ids = new ArrayList<String>();
		if (airs.size() > 0) {
			for (AirConditioner air : airs) {
				ids.add(air.getAirId());
			}
			msg.setCode(200);
			msg.setMessage("获取数据成功");
			msg.setData(ids);
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("获取数据失败");
		return msg;
	}

	@Override
	public ResultMsg findAllAirDetailAirIds() {
		// TODO 自动生成的方法存根 查询所有空调详情里面的空调ID
		ResultMsg msg = new ResultMsg();
		List<AirConditionerDetailInfo> infos = this.airInfoRepository.findAllByIsDeleteFalse();
		List<String> ids = new ArrayList<String>();
		if (infos.size() > 0) {
			for (AirConditionerDetailInfo info : infos) {
				ids.add(info.getAirId());
			}
			msg.setCode(200);
			msg.setMessage("获取数据成功");
			msg.setData(ids);
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("获取数据失败");
		return msg;
	}

	// 空调详情(管理端)
	@Override
	public ResultMsg searchAirDetailInfo(String keyword, int pageNumber) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		Pageable pageable = PageRequest.of(pageNumber, 10);
		Page<AirConditionerDetailInfo> page;
		if (StringUtils.isEmpty(keyword)) {
			page = this.airInfoRepository.findByIsDeleteFalse(pageable);
			msg.setCode(200);
			msg.setMessage("获取详情列表成功");
			msg.setTotal(page.getTotalElements());
			msg.setData(page.getContent());
			return msg;
		} else {
			page = this.airInfoRepository.findByIsDeleteFalseAndAirNameContaining(keyword, pageable);
			msg.setCode(200);
			msg.setMessage("获取详情列表成功");
			msg.setTotal(page.getTotalElements());
			msg.setData(page.getContent());
			return msg;
		}
	}

	@Override
	public ResultMsg findAirDetailInfoById(String airId) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		AirConditionerDetailInfo info = this.airInfoRepository.findByAirId(airId);
		if (info != null) {
			msg.setCode(200);
			msg.setMessage("success");
			msg.setData(info);
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("fail");
		return msg;
	}

	@Override
	public ResultMsg deleteAirDetailInfos(List<String> airDetailIds) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		List<AirConditionerDetailInfo> list = this.airInfoRepository.findAllById(airDetailIds);
		if (list.size() > 0) {
			for (AirConditionerDetailInfo info : list) {
				info.setIsDelete(true);
			}
			this.airInfoRepository.saveAll(list);
			msg.setCode(200);
			msg.setMessage("删除成功");
			return msg;
		}
		msg.setCode(200);
		msg.setMessage("删除失败");
		return msg;
	}

	@Override
	public ResultMsg updateAirDetailInfo(AirConditionerDetailInfo air) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		if (this.airInfoRepository.save(air) != null) {
			msg.setCode(200);
			msg.setMessage("操作成功");
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("操作失败");
		return msg;
	}

	@Override
	public ResultMsg getAirDetailInfo(String airDetailId) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		AirConditionerDetailInfo info = this.airInfoRepository.findByAirDetailIdAndIsDeleteFalse(airDetailId);
		if (info != null) {
			msg.setCode(200);
			msg.setMessage("获取成功");
			msg.setData(info);
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("获取失败");
		return msg;
	}

	// 租赁信息(管理端)
	@Override
	public ResultMsg searchAirLeaseInfo(String airName, String username, int pageNumber) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		Pageable pageable = PageRequest.of(pageNumber, 10);
		Page<LeaseInfo> page;
		if (StringUtils.isEmpty(airName) && StringUtils.isEmpty(username)) {
			page = this.leaseInfoRepository.findByIsDeleteFalse(pageable);
			msg.setCode(200);
			msg.setMessage("获取租赁列表成功");
			msg.setTotal(page.getTotalElements());
			msg.setData(page.getContent());
			return msg;
		} else {
			if (StringUtils.isEmpty(username)) {
				page = this.leaseInfoRepository.findByIsDeleteFalseAndAirNameContaining(airName, pageable);
				msg.setCode(200);
				msg.setMessage("获取租赁列表成功");
				msg.setTotal(page.getTotalElements());
				msg.setData(page.getContent());
				return msg;
			} else if (StringUtils.isEmpty(airName)) {
				page = this.leaseInfoRepository.findByIsDeleteFalseAndUsernameContaining(username, pageable);
				msg.setCode(200);
				msg.setMessage("获取租赁列表成功");
				msg.setTotal(page.getTotalElements());
				msg.setData(page.getContent());
				return msg;
			} else {
				page = this.leaseInfoRepository.findByIsDeleteFalseAndUsernameContainingAndAirNameContaining(airName,
						username, pageable);
				msg.setCode(200);
				msg.setMessage("获取租赁列表成功");
				msg.setTotal(page.getTotalElements());
				msg.setData(page.getContent());
				return msg;
			}
		}
	}

	@Override
	public ResultMsg findAirLeaseInfoById(String leaseId) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		LeaseInfo info = this.leaseInfoRepository.findByLeaseId(leaseId);
		if (info != null) {
			msg.setCode(200);
			msg.setMessage("获取租赁信息成功");
			msg.setData(info);
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("获取租赁信息失败");
		return msg;
	}

	@Override
	public ResultMsg deleteAirLeaseInfos(List<String> leaseIds) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		List<LeaseInfo> infos = this.leaseInfoRepository.findAllById(leaseIds);
		if (infos.size() > 0) {
			for (LeaseInfo info : infos) {
				info.setIsDelete(true);
			}
			this.leaseInfoRepository.saveAll(infos);
			msg.setCode(200);
			msg.setMessage("删除成功");
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("删除失败");
		return msg;
	}

	@Override
	public ResultMsg updateAirLeaseInfo(LeaseInfo info) {
		// TODO 自动生成的方法存根
		ResultMsg msg = new ResultMsg();
		if (this.leaseInfoRepository.save(info) != null) {
			msg.setCode(200);
			msg.setMessage("操作成功");
			return msg;
		}
		msg.setCode(500);
		msg.setMessage("操作失败");
		return msg;
	}

}
