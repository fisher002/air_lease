package com.air.lease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.lease.domain.AirConditionerDetailInfo;

@Repository
public interface AirInfoRepository extends JpaRepository<AirConditionerDetailInfo,String>  {

	AirConditionerDetailInfo findByAirId(String airId);
	
}
