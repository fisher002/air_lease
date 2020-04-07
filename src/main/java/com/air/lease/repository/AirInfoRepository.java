package com.air.lease.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.lease.domain.AirConditionerDetailInfo;

@Repository
public interface AirInfoRepository extends JpaRepository<AirConditionerDetailInfo,String>  {

	AirConditionerDetailInfo findByAirId(String airId);

	Page<AirConditionerDetailInfo> findByIsDeleteFalse(Pageable pageable);

	Page<AirConditionerDetailInfo> findByIsDeleteFalseAndAirNameContaining(String keyword, Pageable pageable);

	AirConditionerDetailInfo findByAirDetailIdAndIsDeleteFalse(String airDetailId);

	List<AirConditionerDetailInfo> findAllByIsDeleteFalse();
	
}
