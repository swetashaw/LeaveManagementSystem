package com.project.leavemanagement.dto;

import java.util.Date;


/**
 * @author Sweta
 * Dto for leave requests
 *
 */
public class LeaveRequestDto {
	
	 
	    private Long id;

	   
	    private long userId;

	    
	    private String employeeName;

	    
	    
	    private Date fromDate;

	    
	   
	    private Date toDate;

	   
	    
	    private String leaveType;

	   
	   
	    private String reason;

	   

	   
	    private boolean acceptRejectFlag;



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public long getUserId() {
			return userId;
		}



		public void setUserId(long userId) {
			this.userId = userId;
		}



		public String getEmployeeName() {
			return employeeName;
		}



		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}



		public Date getFromDate() {
			return fromDate;
		}



		public void setFromDate(Date fromDate) {
			this.fromDate = fromDate;
		}



		public Date getToDate() {
			return toDate;
		}



		public void setToDate(Date toDate) {
			this.toDate = toDate;
		}



		public String getLeaveType() {
			return leaveType;
		}



		public void setLeaveType(String leaveType) {
			this.leaveType = leaveType;
		}



		public String getReason() {
			return reason;
		}



		public void setReason(String reason) {
			this.reason = reason;
		}



		public boolean isAcceptRejectFlag() {
			return acceptRejectFlag;
		}



		public void setAcceptRejectFlag(boolean acceptRejectFlag) {
			this.acceptRejectFlag = acceptRejectFlag;
		}

	  
	    

	   

}
