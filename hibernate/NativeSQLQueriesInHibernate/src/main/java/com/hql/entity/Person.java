package com.hql.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_table")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "per_id")
	private Integer personId;
	
	@Column(name = "per_name")
	private String personName;
	
	@Column(name="dob")
	private Date dabeOfBirth;
	
	@Column(name="per_age")
	private Integer personAge;

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Date getDabeOfBirth() {
		return dabeOfBirth;
	}

	public void setDabeOfBirth(Date dabeOfBirth) {
		this.dabeOfBirth = dabeOfBirth;
	}

	public Integer getPersonAge() {
		return personAge;
	}

	public void setPersonAge(Integer personAge) {
		this.personAge = personAge;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", dabeOfBirth=" + dabeOfBirth
				+ ", personAge=" + personAge + "]";
	}
	
}
