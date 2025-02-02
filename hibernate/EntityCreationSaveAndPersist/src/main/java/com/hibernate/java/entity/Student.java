package com.hibernate.java.entity;

import java.util.Date;

public class Student {

	private Integer studentId;
	private String studentName;
	//private Date dateOfBirth;
	private Long phone;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
//	public Date getDateOfBirth() {
//		return dateOfBirth;
//	}
//	public void setDateOfBirth(Date dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Student(Integer studentId, String studentName,  Long phone) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		//this.dateOfBirth = dateOfBirth;
		this.phone = phone;
	}
	public Student() {
		super();
	}
	
	public Student( String studentName,  Long phone) {
		super();
		this.studentName = studentName;
		//this.dateOfBirth = dateOfBirth;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + " ,"
				+ ", phone=" + phone + "]";
	}
	
	
	
}
