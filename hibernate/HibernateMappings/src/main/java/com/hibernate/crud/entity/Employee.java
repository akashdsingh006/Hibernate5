package com.hibernate.crud.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_table")
public class Employee {
	
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	
	@Column(name = "employee_name")
	private String employeeNAme;
	
	@Column(name="salary")
	private Double salary;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="bank_id")
	private BankingDetails bankingDetails;
	
	//Bi-directional Relation
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "employee")
	private List<Address> addresses;
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeNAme() {
		return employeeNAme;
	}

	public void setEmployeeNAme(String employeeNAme) {
		this.employeeNAme = employeeNAme;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public BankingDetails getBankingDetails() {
		return bankingDetails;
	}

	public void setBankingDetails(BankingDetails bankingDetails) {
		this.bankingDetails = bankingDetails;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeNAme=" + employeeNAme + ", salary=" + salary
				+ ", bankingDetails=" + bankingDetails + "]";
	}
	
	
	
}
