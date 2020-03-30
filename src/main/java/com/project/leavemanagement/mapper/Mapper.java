package com.project.leavemanagement.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.project.leavemanagement.dto.LeaveRequestDto;
import com.project.leavemanagement.dto.UserDto;
import com.project.leavemanagement.dto.UserLeavesDto;
import com.project.leavemanagement.entity.LeaveRequest;
import com.project.leavemanagement.entity.User;
import com.project.leavemanagement.entity.UserLeaves;
@Component
public class Mapper {
	
	public UserDto mapUserEntitytoDto(User user) {
		
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setActive(user.isActive());
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setRole(user.getRole());
		userDto.setUserName(user.getUserName());
		return userDto;
		
	}
	
public LeaveRequestDto mapLeaveRequestEntitytoDto(LeaveRequest leaveReq) {
		
	LeaveRequestDto leaveReqDto=new LeaveRequestDto();
	leaveReqDto.setId(leaveReq.getId());
	leaveReqDto.setAcceptRejectFlag(leaveReq.isAcceptRejectFlag());
	leaveReqDto.setEmployeeName(leaveReq.getEmployeeName());
	leaveReqDto.setFromDate(leaveReq.getFromDate());
	leaveReqDto.setToDate(leaveReq.getToDate());
	leaveReqDto.setLeaveType(leaveReq.getLeaveType());
	if(null!=leaveReq.getUser().getId()) {
	leaveReqDto.setUserId(leaveReq.getUser().getId());
	}
	leaveReqDto.setReason(leaveReq.getReason());
		return leaveReqDto;
		
	}
	
public User mapUserEntitytoDto(UserDto userdto) {
		
		User user=new User();
		user.setId(userdto.getId());
		user.setActive(userdto.isActive());
		user.setEmail(userdto.getEmail());
		user.setFirstName(userdto.getFirstName());
		user.setLastName(userdto.getLastName());
		user.setRole(userdto.getRole());
		user.setUserName(userdto.getUserName());
		return user;
		
	}

public LeaveRequest mapLeaveRequestDtoEntity(LeaveRequestDto leaveReqDto) {
	System.out.println("Inside Mapper");
	LeaveRequest leaveReq=new LeaveRequest();
	System.out.println("leaveReqDto.getId()"+leaveReqDto.getId());
	leaveReq.setId(leaveReqDto.getId());
	boolean a=true;
	if(leaveReqDto.isAcceptRejectFlag()) {
		System.out.println("leaveReqDto.getId()"+leaveReqDto.getId());
		leaveReq.setAcceptRejectFlag(a);	
	}
	else {
		a=false;
		leaveReq.setAcceptRejectFlag(a);
	}
	
	leaveReq.setEmployeeName(leaveReqDto.getEmployeeName());
	leaveReq.setFromDate(leaveReqDto.getFromDate());
	leaveReq.setToDate(leaveReqDto.getToDate());
	leaveReq.setLeaveType(leaveReqDto.getLeaveType());
	leaveReq.getUser().setId(leaveReqDto.getUserId());
	leaveReq.setReason(leaveReqDto.getReason());
		return leaveReq;
		
	}

public UserLeavesDto mapUserLeavesEntityToDto(UserLeaves userLeaves) {
	
	UserLeavesDto userLeavesDto=new UserLeavesDto();
	userLeavesDto.setId(userLeaves.getId());
	userLeavesDto.setEmployeeName(userLeaves.getEmployeeName());
	userLeavesDto.setLeaveType(userLeaves.getLeaveType());
	userLeavesDto.setQuantity(userLeaves.getQuantity());
	userLeavesDto.setUserId(userLeaves.getUser().getId());
	return userLeavesDto;
	
}

public UserLeaves mapUserLeavesDtoToEntity(UserLeavesDto userLeavesdto) {
	UserLeaves userLeaves=new UserLeaves();
	userLeaves.setId(userLeavesdto.getId());
	userLeaves.setEmployeeName(userLeavesdto.getEmployeeName());
	userLeaves.setLeaveType(userLeavesdto.getLeaveType());
	userLeaves.setQuantity(userLeavesdto.getQuantity());
	userLeaves.getUser().setId(userLeavesdto.getUserId());
	return null;
	
}

public List<UserDto> mapUserEntityListToDtoList(List<User> userList) {
	// TODO Auto-generated method stub
	
	List<UserDto> userDto=new ArrayList<UserDto>();
	
		if(!CollectionUtils.isEmpty(userList))
		{
			for(User usr: userList)
			{
				userDto.add(mapUserEntitytoDto(usr));
				
			}
		}
		return userDto;
		
	
	
	
}

public List<LeaveRequestDto> mapLeaveRequestEntityListToDtoList(List<LeaveRequest> LeaveRequest) {
	// TODO Auto-generated method stub
	
	List<LeaveRequestDto> leaveReqDto=new ArrayList<LeaveRequestDto>();
	
		if(!CollectionUtils.isEmpty(LeaveRequest))
		{
			for(LeaveRequest leaveRequest: LeaveRequest)
			{
				leaveReqDto.add(mapLeaveRequestEntitytoDto(leaveRequest));
				
			}
		}
		return leaveReqDto;
		
	
	
	
}

public List<UserLeavesDto> mapUserLeavesEntityListToDtoList(List<UserLeaves> userLeaves) {
	// TODO Auto-generated method stub
	
	List<UserLeavesDto> leaveReqDto=new ArrayList<UserLeavesDto>();
	
		if(!CollectionUtils.isEmpty(userLeaves))
		{
			for(UserLeaves userLeavesfor: userLeaves)
			{
				leaveReqDto.add(mapUserLeavesEntityToDto(userLeavesfor));
				
			}
		}
		return leaveReqDto;
		
	
	
	
}



}
