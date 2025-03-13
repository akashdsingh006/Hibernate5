package com.hql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_tb")
public class Student {

	@Id
	@Column(name = "stu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	
	@Column(name = "stu_name")
	private String studentName;
	
	@Column(name = "marks")
	private Double studentMarks;
	
	@Column(name = "rank")
	private Integer studentRank;

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

	public Double getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(Double studentMarks) {
		this.studentMarks = studentMarks;
	}

	public Integer getStudentRank() {
		return studentRank;
	}

	public void setStudentRank(Integer studentRank) {
		this.studentRank = studentRank;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentMarks=" + studentMarks
				+ ", studentRank=" + studentRank + "]";
	}
	
}
