package com.java.infinite;

import java.nio.channels.ShutdownChannelGroupException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LeaveMain { 
	static Scanner sc = new Scanner(System.in); 
	
	
	
	public static void addleave() throws LeaveException, ParseException {
		LeaveDetails leave = new LeaveDetails();
		System.out.println("Enter Leave id"); 
		leave.setLeaveId(sc.nextInt()); 
		
		System.out.println("Enter leave Startdate in dd-MM-yyyy format"); 
		SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
		leave.setLeaveStartDate(sd.parse(sc.next())); 
		
		System.out.println("Enter leave Enddate in dd-MM-yyyy format"); 
		leave.setLeaveEndDate(sd.parse(sc.next())); 
		
		System.out.println("Enter empid"); 
		leave.setEmpId(sc.nextInt());   

		System.out.println("Enter Leave details");
		leave.setLeaveReason(sc.next());
		LeaveBAL bal=new LeaveBAL();
		bal.addLeaveBal(leave);
		System.out.println("Leave Details added succesfully");
		
	}
	public static void showAllLeaves() { 
		List<LeaveDetails> leaveList =new LeaveBAL().showAllLeaves(); 
		for (LeaveDetails leaveDetails : leaveList) {
			System.out.println(leaveDetails);
		}
	} 
	
	public static void searchLeave(){
		System.out.println("enter emp id"); 
		int empId=sc.nextInt();
		LeaveDetails leave =new LeaveBAL().searchLeave(empId); 
		if(leave!=null){
			System.out.println(leave);
				
			}else{
				System.out.println("record not found................");
		} 
	}
	public static void deleteLeave(){
		System.out.println("enter empid "); 
		int empId=sc.nextInt();
		System.out.println(	new LeaveBAL().deleteLeave(empId));
	} 
	
	public static void updateLeave() throws ParseException, LeaveException{
		LeaveDetails leave= new LeaveDetails();
		
		System.out.println("enter emp id"); 
		System.out.println("Enter Leave id"); 
		leave.setLeaveId(sc.nextInt()); 
		
		System.out.println("Enter leave Startdate in dd-MM-yyyy format"); 
		SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
		leave.setLeaveStartDate(sd.parse(sc.next())); 
		
		System.out.println("Enter leave Enddate in dd-MM-yyyy format"); 
		leave.setLeaveEndDate(sd.parse(sc.next())); 
		
		System.out.println("Enter empid"); 
		leave.setEmpId(sc.nextInt());   

		System.out.println("Enter Leave details");
		leave.setLeaveReason(sc.next()); 
		
		LeaveBAL bal= new LeaveBAL();
		System.out.println(bal.updateLeaveBal(leave));
	}
	
	public static void main(String[] args) throws ParseException, LeaveException {
		int ch;
		do{
			System.out.println("O P T I O N S.........."); 
			System.out.println("1.Add leave");
			System.out.println("2.Show Allleave"); 
			System.out.println("3.Search leave");
			System.out.println("4.Deleteleave");
			System.out.println("5.Updateleave");  
			
		
			ch= sc.nextInt();
			switch(ch){
			case 1: 
				  try {
					addleave();
				} catch (LeaveException e) {
					System.out.println(e.getMessage());
				}
				break;
			
			case 2: 
				showAllLeaves();
				break;  
			case 3: 
				searchLeave();
				break;
			case 4: 
				deleteLeave();
				break;
			case 5:
				updateLeave();
				break;
			case 6: 
				return;
			}
		} while(ch!=6);
	} 
	
}
