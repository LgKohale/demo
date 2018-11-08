package com.capgemini.jpa.presentation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.jpa.entity.Employee;
import com.capgemini.jpa.exception.EmployeeException;
import com.capgemini.jpa.service.EmployeeServiceImpl;
import com.capgemini.jpa.service.IEmployeeService;

public class EmployeeTester {
	private static IEmployeeService employeeService=
								new EmployeeServiceImpl();
	private static Scanner sc =  new Scanner(System.in);
	
	public static void main(String[] args) throws EmployeeException {
		/*Employee employee=
		    new Employee(null,"Ravi",new GregorianCalendar(2016,1,12),"CLerk",61650.0,10);
		*/
		while(true){
			System.out.println("1. Add Employee Detils");
			System.out.println("2. Delete Employee Details");
			System.out.println("3. Show Employee Details");
			System.out.println("4. Update Employee Details");
			System.out.println("5.Query");
			System.out.println("6. Exit");
			System.out.println("-------------------------------");
			System.out.println("Enter your choice: ");
		
				int option= sc.nextInt();
				switch(option){
				case 1:
					Employee employee1= new Employee();
					getEmployeeDetails(employee1);
					addNewEmployee(employee1);
					System.out.println(employee1);
					break;
					
				case 2:
					System.out.println("Enter the employee id: ");
					int id= sc.nextInt();
					deleteEmployee(id);
					
					break;
					
				case 3:
				
					List<Employee> empList= employeeService.getAllEmployees();
					showEmployees(empList);
						
					break;
					
					
				case 4:
					
					try{
						Employee emp= employeeService.getEmployeeDetails(2);
						System.out.println(emp);
						emp.setSalary(6000.0);
						employeeService.updateEmployee(emp);
						emp=employeeService.getEmployeeDetails(2);
						System.out.println(emp);
						
					}catch(Exception e){
						e.printStackTrace();
					}
					
					
					break;
					
				case 5:
					
					
				case 6:
					System.exit(0);
				default:
					System.out.println("Enter Proper option: (1-4)");
				
				}
			}
		
	}

	private static void showEmployees(List<Employee> empList) {
		Iterator<Employee> it= empList.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}


	private static void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		try {
			employeeService.deleteEmployee(id);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getEmployeeDetails(Employee employee1) {
		System.out.println("Enter employee Id: ");
		employee1.setEmpid(sc.nextInt());
		System.out.println("Enter employee name:");
		employee1.setEname(sc.next());
		System.out.println("Enter employee hiredate:(YYYY-MM-DD): ");
		String hdate=sc.next();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			java.util.Date udate = df.parse(hdate);
			Calendar cdate=Calendar.getInstance();
			cdate.setTime(udate);
			employee1.setHiredate(cdate);
			
		} catch (ParseException e) {		
			e.printStackTrace();
		}
			
		System.out.println("Enter your job:");
		employee1.setJob(sc.next());
		System.out.println("Enter your salary: ");
		employee1.setSalary(sc.nextDouble());
		System.out.println("Enter department number: ");
		employee1.setDeptno(sc.nextInt());
		
	}

	private static void addNewEmployee(Employee employee) {
		try {
			employeeService.addNewEmployee(employee);
		} catch (EmployeeException e) {			
			e.printStackTrace();
		}
		
	}

}
