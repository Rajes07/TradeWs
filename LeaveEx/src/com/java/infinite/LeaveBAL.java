package com.java.infinite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LeaveBAL {

	static StringBuilder sb = new StringBuilder();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	public boolean validateLeave(LeaveDetails leave) throws ParseException {
		boolean valid = true;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		
		String yesterday = sdf.format(cal.getTime());

		if (leave.getLeaveStartDate().before(sdf.parse(yesterday))) {
			valid = false;
			sb.append("leaveStartDate cannot be yesterdays date");
		}
		if (leave.getLeaveEndDate().before(sdf.parse(yesterday))) {
			valid = false;
			sb.append("leaveEndDate cannot be yesterdays date");
		}
		if (!(leave.getLeaveStartDate().before(leave.getLeaveEndDate())
				|| leave.getLeaveStartDate().equals(leave.getLeaveEndDate()))) {
			valid = false;
			sb.append("leaveStartDate must be less than or equals to leaveEndDate");
		}
		return valid;

	}

	public String addLeaveBal(LeaveDetails leave) throws LeaveException, ParseException {
		if (validateLeave(leave)) {
			
			leave.setLeaveAppliedOn(new Date());
			leave.setNoOfDays(((leave.getLeaveEndDate().getTime()-leave.getLeaveStartDate().getTime())/(1000 * 60 * 60 * 24))% 365);
			return new LeaveDAO().addLeaveDao(leave);
		} else {
			throw new LeaveException(sb.toString());
		} 
		
		
		}
		
	public List<LeaveDetails> showAllLeaves(){
		return new LeaveDAO().showAllLeaves();
	} 
	
	public LeaveDetails searchLeave(int empId){
		return new LeaveDAO().searchLeaveDao(empId);
		
	}
    public String deleteLeave(int empId){
    	return new LeaveDAO().deleteLeave(empId);
    	} 
    public String updateLeaveBal(LeaveDetails leave) throws LeaveException{
    	try {
			if(validateLeave(leave)){
				return new LeaveDAO().updateLeave(leave);
			}
			else{
				throw new LeaveException(sb.toString());
			}
			
				
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
		return null;
    	
    }
	} 
	


