package com.project.leavemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;	
import org.springframework.web.bind.annotation.RestController;

import com.project.leavemanagement.dto.UserDto;
import com.project.leavemanagement.exception.RecordNotFoundException;
import com.project.leavemanagement.mapper.Mapper;
import com.project.leavemanagement.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	Mapper mapper;
	
	/**
	 * @return List of users
	 */
	@GetMapping("/user")
	public List<UserDto> getAllAccounts() {
		List<UserDto> list = userService.getAllUsers();
		return list;
		 
	}
	
	

	/**
	 * @param id
	 * @return List of user based on user id passed
	 * @throws RecordNotFoundException
	 */
	@GetMapping("/user/{id}")
	public Optional getUserById(@PathVariable("id") Long id) throws RecordNotFoundException {
		return userService.getUserId(id);

	}


}
