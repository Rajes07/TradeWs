package com.java.infinite;

public class LeaveException extends Exception{ 
	
	public String errorMsg;

	public LeaveException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}

	public LeaveException() {
		super();
	}
	
	
	

}
