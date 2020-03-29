package com.air.lease.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.lease.domain.LeaseInfo;

@Repository
public interface LeaseInfoRepository extends JpaRepository<LeaseInfo, String>{

	Page<LeaseInfo> findByIsDeleteFalseAndUserId(String airId, Pageable pageable);

	Page<LeaseInfo> findByIsDeleteFalse(Pageable pageable);

	LeaseInfo findByLeaseId(String leaseId);

}
