package com.project.leavemanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.leavemanagement.dto.LeaveRequestDto;
import com.project.leavemanagement.dto.UserLeavesDto;
import com.project.leavemanagement.entity.LeaveRequest;
import com.project.leavemanagement.entity.UserLeaves;
import com.project.leavemanagement.mapper.Mapper;
import com.project.leavemanagement.repository.LeaveManageNativeSqlRepo;
import com.project.leavemanagement.repository.LeaveRequestRepository;
import com.project.leavemanagement.repository.UserLeavesRepository;
	


/**
 * @author sweta
 *
 */
/**
 * @author anup
 *
 */
@Service
public class LeaveManagementService {
	
	
	  @Autowired UserLeavesRepository userLeavesRepo;
	 
	  @Autowired LeaveRequestRepository leaveReqRepository;
	  
	  @Autowired
	  UserLeavesRepository userLeavesrepo;
	  
	  @Autowired
	  LeaveManageNativeSqlRepo lmNativeSqlRepo;
	  
	 //mapper injected 
	 @Autowired
	 Mapper mapper;
	  
		/**
		 * gets All leave request made my users
		 * @return
		 */
		public List<LeaveRequestDto> getAllLeaveRequests() {
			List<LeaveRequest> leaveReqList = leaveReqRepository.findAll();
			// logger.info("Inside GetAll Users");
			if (leaveReqList.size() > 0) {
				List<LeaveRequestDto> leaveReqDto = mapper.mapLeaveRequestEntityListToDtoList(leaveReqList);
				return leaveReqDto;
			} else {

				return new ArrayList<LeaveRequestDto>();
			}

		}
	  
	  /**
	 * @return
	 */
	public List<UserLeavesDto> getAllUserLeaves() {
			List<UserLeaves> leaveReqList = userLeavesrepo.findAll();
			//logger.info("Inside GetAll Users");
			if (leaveReqList.size() > 0) {
				List<UserLeavesDto>leaveReqDto=mapper.mapUserLeavesEntityListToDtoList(leaveReqList);
				return leaveReqDto;
			} else {
				
				return new ArrayList<UserLeavesDto>();
			}
				
	  }
	  
	  /**
	 * @param user_id
	 * @return
	 */
	public List<UserLeavesDto> getUserLeavesOnUserId(Long user_id) {

			StringBuffer whereQuery = new StringBuffer();
			
			    whereQuery.append("user_id='").append(user_id).append("'");
			    List<UserLeaves> ls=lmNativeSqlRepo.getAllLeavesOnUserId(whereQuery);
				//Object leaveManageNativeRepo;
				  if (ls.size() > 0) {
						List<UserLeavesDto> leaveReqDto=mapper.mapUserLeavesEntityListToDtoList(ls);
						return leaveReqDto;
					} else {
						
						return new ArrayList<UserLeavesDto>();
					}
		    }
	  
	  public List<LeaveRequestDto> getLeaveRequestOnUserId(Long user_id) {

			StringBuffer whereQuery = new StringBuffer();
			
			    whereQuery.append("user_id='").append(user_id).append("'");
			
			  List<LeaveRequest> ls=lmNativeSqlRepo.getLeaveRequestOnUserId(whereQuery);
			
			  if (ls.size() > 0) {
					List<LeaveRequestDto> leaveReqDto=mapper.mapLeaveRequestEntityListToDtoList(ls);
					return leaveReqDto;
				} else {
					
					return new ArrayList<LeaveRequestDto>();
				}
			
		    }

	/**
	 * @param leaveRequestDto
	 * @return
	 */
	public LeaveRequestDto raiseLeaveRequest(LeaveRequestDto leaveRequestDto) {
		
		if(null!=leaveRequestDto) {
		LeaveRequest leaveReq=mapper.mapLeaveRequestDtoEntity(leaveRequestDto);
		System.out.println("Ist mapper done");
		System.out.println("leaveReq"+leaveReq);
		LeaveRequest leaveRequestSaved=leaveReqRepository.save(leaveReq);
		System.out.println("Saved");
		return mapper.mapLeaveRequestEntitytoDto(leaveRequestSaved);
		}
		else {
			return new LeaveRequestDto();
		}
		 
		
	}

	/**
	 * @param leaveReqDto
	 * @return
	 */
	public LeaveRequest requestLeave(LeaveRequest leaveReqDto) {
		LeaveRequest leaveRequest=leaveReqRepository.save(leaveReqDto);
		return leaveRequest;
	}
}
