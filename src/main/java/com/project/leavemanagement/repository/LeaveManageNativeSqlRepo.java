package com.project.leavemanagement.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.project.leavemanagement.entity.LeaveRequest;
import com.project.leavemanagement.entity.UserLeaves;



@Repository
public class LeaveManageNativeSqlRepo {

    @PersistenceContext
    EntityManager entityManager;


    
    public List<UserLeaves> getAllLeavesOnUserId(StringBuffer whereQuery) {

	Query query = entityManager.createNativeQuery("select * from user_leaves where " + whereQuery,
			UserLeaves.class);
	
	return query.getResultList();
    }
    
  
    public List<LeaveRequest> getLeaveRequestOnUserId(StringBuffer whereQuery) {

	Query query = entityManager.createNativeQuery("select * from leave_request  where " + whereQuery,
			LeaveRequest.class);
	
	return query.getResultList();
    }
}
