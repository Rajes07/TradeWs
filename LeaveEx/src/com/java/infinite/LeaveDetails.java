package com.java.infinite;

import java.util.Date;

public class LeaveDetails {

	private int leaveId;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private int empId;
	private long noOfDays;
	private Date leaveAppliedOn;
	private String leaveReason;
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public Date getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public Date getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public long getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(long noOfDays) {
		this.noOfDays = noOfDays;
	}
	public Date getLeaveAppliedOn() {
		return leaveAppliedOn;
	}
	public void setLeaveAppliedOn(Date leaveAppliedOn) {
		this.leaveAppliedOn = leaveAppliedOn;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public LeaveDetails(int leaveId, Date leaveStartDate, Date leaveEndDate, int empId, long noOfDays,
			Date leaveAppliedOn, String leaveReason) {
		super();
		this.leaveId = leaveId;
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.empId = empId;
		this.noOfDays = noOfDays;
		this.leaveAppliedOn = leaveAppliedOn;
		this.leaveReason = leaveReason;
	}
	public LeaveDetails() {
		super();
	}
	@Override
	public String toString() {
		return "LeaveDetails [leaveId=" + leaveId + ", leaveStartDate=" + leaveStartDate + ", leaveEndDate="
				+ leaveEndDate + ", empId=" + empId + ", noOfDays=" + noOfDays + ", leaveAppliedOn=" + leaveAppliedOn
				+ ", leaveReason=" + leaveReason + "]";
	}

	}
