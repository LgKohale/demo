package com.capgemini.jpa.presentation;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.capgemini.jpa.entity.Employee;
import com.capgemini.jpa.utility.JPAUtil;

public class JP12Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager entitymanager= JPAUtil.getEntityManager();
	//	String jql1 = "select e from Employee e";
		//pjob is named parameter
		/*String jql1= "select e from Employee e where e.job=:pjob AND e.salary>:psal";
		TypedQuery tQuery= entitymanager.createQuery(jql1,Employee.class);
		tQuery.setParameter("pjob", "manager").setParameter("psal", 40000.00);
		List<Employee> empList = tQuery.getResultList();
		showEmployees(empList);*/
		
		Query jq1=entitymanager.createNamedQuery("q1");
		List<Employee> list= jq1.getResultList();
		showEmployees(list);
		
		
	}

	private static void showEmployees(List<Employee> empList) {
		Iterator<Employee> it= empList.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}
