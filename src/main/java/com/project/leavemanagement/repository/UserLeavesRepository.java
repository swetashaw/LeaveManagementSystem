package com.project.leavemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.leavemanagement.entity.UserLeaves;

@Repository
public interface UserLeavesRepository extends  JpaRepository<UserLeaves,Long>{

}
