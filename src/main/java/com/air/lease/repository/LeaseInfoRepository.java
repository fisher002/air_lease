package com.air.lease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.lease.domain.LeaseInfo;

@Repository
public interface LeaseInfoRepository extends JpaRepository<LeaseInfo, String>{

}
