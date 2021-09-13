package com.java.infinite;

import java.util.ArrayList;
import java.util.List;

public class LeaveDAO { 
	static List<LeaveDetails> lstList; 
	
	static{
		lstList=new ArrayList<LeaveDetails>();
	}
	 
	
	public String addLeaveDao(LeaveDetails leave) {
		lstList.add(leave);
		return "Student Record added Successfully...";
	}


	public static List<LeaveDetails> showAllLeaves() {
		return lstList;
	} 
	public LeaveDetails searchLeaveDao(int empId){
		LeaveDetails result = null; 
		if(result.getEmpId()==empId){
			result=result;
			
			
		}
		return result;
	}


	public String deleteLeave(int empId) {
		LeaveDetails leave = searchLeaveDao(empId);
		if(leave!=null){
			lstList.remove(empId);
			return"record deleted sucesfully";
		}
		return null;
	} 
	
	public String updateLeave(LeaveDetails leavenew){
		
		LeaveDetails oldLeave = searchLeaveDao(leavenew.getEmpId());
		if(oldLeave!=null){
			oldLeave.setEmpId(leavenew.getEmpId());
			oldLeave.setLeaveEndDate(leavenew.getLeaveEndDate());
			oldLeave.setLeaveId(leavenew.getLeaveId()); 
			oldLeave.setLeaveStartDate(leavenew.getLeaveStartDate()); 
			oldLeave.setNoOfDays(leavenew.getNoOfDays()); 
			oldLeave.setLeaveAppliedOn(leavenew.getLeaveAppliedOn()); 
			System.out.println("record updated sucessfully...............");
		}else{
			return"record not found.....";
		}
		
		
		
		return null;
		
	}
}
