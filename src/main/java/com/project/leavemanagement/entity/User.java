package com.project.leavemanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @authorSweta
 * User Entity CLass
 *
 */
@Entity
@Table(name="user")
public class User {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id")
	    private Long id;

	 
	    @Column(name = "email")
	    private String email;
   
	    @Column(name = "role")
	    private String role;
	    
	    @Column(name = "user_name",nullable=false, unique=true)
	    private String userName;

	 
	    @Column(name = "first_name")	
	    private String firstName;

	    
	    @Column(name = "last_name")
	    private String lastName;

	    @Column(name = "active")
	    private boolean active;

		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinColumn(name = "user_id")
		List<LeaveRequest> leaveReq = new ArrayList<LeaveRequest>();

		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinColumn(name = "user_id")
		List<UserLeaves> userLeaves = new ArrayList<UserLeaves>();

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
		return email;
	    }

	    public void setEmail(String email) {
		this.email = email;
	    }

	    

	    public String getRole() {
		return role;
	    }

	    public void setRole(String role) {
		this.role = role;
	    }

	    public String getFirstName() {
		return firstName;
	    }

	    public void setFirstName(String firstName) {
		this.firstName = firstName;
	    }

	    public String getLastName() {
		return lastName;
	    }

	    public void setLastName(String lastName) {
		this.lastName = lastName;
	    }

	    public boolean isActive() {
		return active;
	    }

	    public void setActive(boolean active) {
		this.active = active;
	    }

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

	
}
