package com.project.leavemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.project.leavemanagement.dto.LeaveRequestDto;
import com.project.leavemanagement.dto.UserDto;
import com.project.leavemanagement.dto.UserLeavesDto;
import com.project.leavemanagement.entity.LeaveRequest;
import com.project.leavemanagement.mapper.Mapper;
import com.project.leavemanagement.service.LeaveManagementService;

@RestController
public class LeaveController {
	
	
	  @Autowired LeaveManagementService leaveService;
	 
	
	@Autowired
	Mapper mapper;
	
	/**
	 * @return list of all leaves applied
	 */
	@GetMapping("/user/leaverequest")
	public List<LeaveRequestDto> getAllLeaveRequest() {
		List<LeaveRequestDto> list = leaveService.getAllLeaveRequests();
		return list;
		 
	}
	
	/**
	 * @return
	 * Used to get leaves of all users
	 */
	@GetMapping("/user/leaves")
	public List<UserLeavesDto> getAllUserLeaves() {
		List<UserLeavesDto> list = leaveService.getAllUserLeaves();
		return list;
		 
	}
	/**
	 * Method to apply leaves
	 * @param leaveReqDto
	 * @return
	 */
	@PostMapping("/sendleaverequests")	
    public ResponseEntity<LeaveRequest> raiseLeaveRequestDirect(@RequestBody  LeaveRequest leaveReqDto)
                                                 {
		LeaveRequest leaveReqDtUupdated = leaveService.raiseLeaveRequestDirect(leaveReqDto);
        return new ResponseEntity<LeaveRequest>(leaveReqDtUupdated, new HttpHeaders(), HttpStatus.CREATED);
    }
	/**
	 * Method used to get leaves of user based on user id
	 * @param id
	 * @return
	 */
	@GetMapping("leaverequest/{userid}")
	public List<LeaveRequestDto> getLeaveRequestOnUserId(@PathVariable("userid") Long id) {
		List<LeaveRequestDto> list = leaveService.getLeaveRequestOnUserId(id);
		return list;
		 
	}
	
	/**
	 * Method to get leaves of a user
	 * @param id
	 * @return
	 */
	@GetMapping("userleaves/{userid}")
	public List<UserLeavesDto> getUserLeaveOnUserId(@PathVariable("userid") Long id) {
		List<UserLeavesDto> list = leaveService.getUserLeavesOnUserId(id);
		return list;
		 
	}
	
	/**
	 * Methos used to apply leaves
	 * @param leaveReqDto
	 * @return
	 */
	@PostMapping("/sendrequest")
    public ResponseEntity<LeaveRequestDto> raiseLeaveRequest(@RequestBody LeaveRequestDto leaveReqDto)
                                                 {
		LeaveRequestDto leaveReqDtUupdated = leaveService.raiseLeaveRequest(leaveReqDto);
        return new ResponseEntity<LeaveRequestDto>(leaveReqDtUupdated, new HttpHeaders(), HttpStatus.CREATED);
    }

	
	
}
