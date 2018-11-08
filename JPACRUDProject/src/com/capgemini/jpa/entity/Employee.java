package com.capgemini.jpa.entity;



import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
		@NamedQuery(name="q1",query="select e from Employee e"),
		@NamedQuery(name="q2",query="select e from Employee e where e.salary>45000.00")
		}
		)
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empid;
	@Column(name="ename", length=30, nullable=false)
	private String ename;
	@Temporal(TemporalType.DATE)
	private Calendar hiredate;
	@NotNull
	private String job;
	private Double salary;
	private Integer deptno;
	
	public Employee() {
		
	}

	public Employee(Integer empid, String ename, Calendar hiredate, String job, Double salary, Integer deptno) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.hiredate = hiredate;
		this.job = job;
		this.salary = salary;
		this.deptno = deptno;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	/*public Calendar getHiredate() {
		return hiredate;
	}*/
	
	public String getHiredate() {
		String hdate= hiredate.get(Calendar.DATE) + "/"+
				hiredate.get(Calendar.MONTH) + "/"+
				hiredate.get(Calendar.YEAR);
		return hdate;
	}

	public void setHiredate(Calendar hdate) {
		this.hiredate = hdate;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		String hdate= hiredate.get(Calendar.DATE) + "/"+
				(hiredate.get(Calendar.MONTH)+1) + "/"+
				hiredate.get(Calendar.YEAR);
		return "Employee [empid=" + empid + ", ename=" + ename + ", hiredate="
				+ hdate + ", job=" + job + ", salary=" + salary
				+ ", deptno=" + deptno + "]";
	}

	
	
	
	
	
	
}
