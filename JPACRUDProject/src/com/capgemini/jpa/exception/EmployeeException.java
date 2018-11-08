package com.capgemini.jpa.exception;

public class EmployeeException extends Exception{
	private String status;
	
	public EmployeeException() {
		this.status="Unable to perform CRUD on table";
	}
	
	public EmployeeException(String status) {
		super(status);
	}
	
	public String getStatus() {
		return this.status;
	}

	@Override
	public String toString() {
		return "EmployeeException [status=" + status + "]";
	}
	
	
}
