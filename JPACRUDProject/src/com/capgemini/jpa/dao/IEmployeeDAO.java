package com.capgemini.jpa.dao;

import java.util.List;

import com.capgemini.jpa.entity.Employee;
import com.capgemini.jpa.exception.EmployeeException;

public interface IEmployeeDAO {
	public abstract void addNewEmployee(Employee employee) throws EmployeeException;
	public abstract void deleteEmployee(Integer empid) throws EmployeeException;
	public abstract void updateEmployee(Employee employee) throws EmployeeException;
	public abstract Employee getEmployeeDetails(Integer empid) throws EmployeeException;
	public abstract List<Employee> getAllEmployees() throws EmployeeException;
}
