package com.entity.objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_table")
public class Student extends Person{
	
	
	@Column(name = "stu_name")
	private String studentAddress;
	
	@Column(name = "stu_age")
	private int studentAge;


	public String studentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	@Override
	public String toString() {
		return "Student [studentAddress=" + studentAddress + ", studentAge=" + studentAge + "]"+super.toString();
	}
	
}
