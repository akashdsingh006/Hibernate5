package com.hql.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="partner")
public class Partner {
	@Id
	@Column(name="partner_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer partnerId;
	
	@Column(name = "name")
	private String partnerName;
	
	@Column(name = "doj")
	private Date partnerJoining;

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public Date getPartnerJoining() {
		return partnerJoining;
	}

	public void setPartnerJoining(Date partnerJoining) {
		this.partnerJoining = partnerJoining;
	}

	@Override
	public String toString() {
		return "Partner [partnerId=" + partnerId + ", partnerName=" + partnerName + ", partnerJoining=" + partnerJoining
				+ "]";
	}
	
}
