package com.smoothstack.lms.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publisherId")
	private Integer pubId;
	
	@Column(name = "publisherName")
	private String pubName;
	
	@Column(name = "publisherAddress")
	private String pubAddress;
	
	@Column(name = "publisherPhone")
	private String pubPhone;
	

	public Integer getPubId() {
		return pubId;
	}

	public void setPubId(Integer pubId) {
		this.pubId = pubId;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

	public String getPubAddress() {
		return pubAddress;
	}

	public void setPubAddress(String pubAddress) {
		this.pubAddress = pubAddress;
	}

	public String getPubPhone() {
		return pubPhone;
	}

	public void setPubPhone(String pubPhone) {
		this.pubPhone = pubPhone;
	}
	
	
	
}
