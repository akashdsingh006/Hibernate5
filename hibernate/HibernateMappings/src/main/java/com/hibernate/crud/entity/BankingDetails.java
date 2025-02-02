package com.hibernate.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "banking_table")
public class BankingDetails {

	@Id
	@Column(name = "bank_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankId;
	
	@Column(name="bank_name", nullable = false)
	private String bankName;
	
	@Column(name="acc_number", nullable = false)
	private Long accountNumber;
	
	@OneToOne(mappedBy = "bankingDetails")
	private Employee employee;

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "BankingDetails [bankId=" + bankId + ", bankName=" + bankName + ", accountNumber=" + accountNumber + "]";
	}
	
	
	
}
