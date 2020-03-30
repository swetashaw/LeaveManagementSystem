package com.project.leavemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.leavemanagement.entity.User;


@Repository
public interface UserRepository extends  JpaRepository<User,Long>{

}
