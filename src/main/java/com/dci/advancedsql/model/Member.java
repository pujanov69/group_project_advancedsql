package com.dci.advancedsql.model;

import java.util.Date;

public class Member {

	private int memId;
	private String surName;
	private String firstName;
	private String address;
	private int zipCode;
	private String telephone;
	private int recommendedBy;
	private Date joinDate;
	
	
	public Member() {
		super();
	}

	
	public Member(int memId, String surName, String firstName, String address, int zipCode, String telephone,
			int recommendedBy, Date joinDate) {
		super();
		this.memId = memId;
		this.surName = surName;
		this.firstName = firstName;
		this.address = address;
		this.zipCode = zipCode;
		this.telephone = telephone;
		this.recommendedBy = recommendedBy;
		this.joinDate = joinDate;
	}


	public int getMemId() {
		return memId;
	}


	public void setMemId(int memId) {
		this.memId = memId;
	}


	public String getSurName() {
		return surName;
	}


	public void setSurName(String surName) {
		this.surName = surName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getZipCode() {
		return zipCode;
	}


	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public int getRecommendedBy() {
		return recommendedBy;
	}


	public void setRecommendedBy(int recommendedBy) {
		this.recommendedBy = recommendedBy;
	}


	public Date getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
