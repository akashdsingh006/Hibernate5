package com.hql.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="employee_aggregate")
@NamedQueries(value = {
		@NamedQuery(name = "findByEmployeeId",query= "SELECT e from Employee e WHERE employeeId=:empId"),
		@NamedQuery(name = "findEmployeeByName", query="SELECT e from Employee e WHERE employeeName=:empName")
		
})
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer employeeId;
	
	@Column(name = "emp_name")
	private String employeeName;
	
	@Column(name = "emp_salary")
	private Double employeeSalary;
	
	@Column(name = "doj")
	private Date dateOfJoining;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + ", dateOfJoining=" + dateOfJoining + "]";
	}
	
	
}
