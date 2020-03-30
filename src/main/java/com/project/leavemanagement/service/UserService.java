package com.project.leavemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.leavemanagement.dto.UserDto;
import com.project.leavemanagement.entity.User;
import com.project.leavemanagement.exception.RecordNotFoundException;
import com.project.leavemanagement.mapper.Mapper;
import com.project.leavemanagement.repository.UserRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * @author Sweta
 * User Service Class
 */
@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	Mapper mapper;
	
	/**
	 * @return List of All users
	 */
	public List<UserDto> getAllUsers() {
		List<User> userList = userRepo.findAll();
		logger.info("Inside GetAll Users");
		if (userList.size() > 0) {
			List<UserDto> userDTOList=mapper.mapUserEntityListToDtoList(userList);
			return userDTOList;
		} else {
			
			return new ArrayList<UserDto>();
		}
	}	
	
	/**
	 * @param id
	 * @return User list
	 * @throws RecordNotFoundException
	 */
	public Optional getUserId(Long id) throws RecordNotFoundException {
		//UserDto userDto=new UserDto();
		
		return userRepo.findById(id);
		
		
		
	}
	
	
}
