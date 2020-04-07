package com.air.lease.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.lease.domain.AirConditioner;

@Repository
public interface AirRepository extends JpaRepository<AirConditioner,String> {

	AirConditioner findByAirId(String airId);
	
	Page<AirConditioner> findByIsDeleteFalse(Pageable pageable);

	Page<AirConditioner> findByIsDeleteFalseAndAirNameContaining(String keyword, Pageable pageable);

	List<AirConditioner> findAllByIsDeleteFalse();

}
