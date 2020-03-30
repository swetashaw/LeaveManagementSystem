package com.project.leavemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.leavemanagement.entity.LeaveRequest;

@Repository
public interface LeaveRequestRepository extends  JpaRepository<LeaveRequest,Long>{

}
