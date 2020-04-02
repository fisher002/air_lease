package com.air.lease.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.air.lease.domain.UserComment;

@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, String> {

	Page<UserComment> findByAirIdAndIsDeleteFalse(String airId, Pageable pageable);

}
