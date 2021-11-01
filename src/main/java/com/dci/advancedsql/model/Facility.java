package com.dci.advancedsql.model;

public class Facility {

	private int facId;
	private String name;
	private int memberCost;
	private int guestCost;
	private int initialOutlay;
	private int monthlyMaintenance;
	
	
	
	public Facility(int facid, String name, int membercost, int guestcost, int initialoutlay, int monthlymaintenance) {
		super();
		this.facId = facid;
		this.name = name;
		this.memberCost = membercost;
		this.guestCost = guestcost;
		this.initialOutlay = initialoutlay;
		this.monthlyMaintenance = monthlymaintenance;
	}
	
	
	
	public Facility() {
		super();
	}



	public int getFacid() {
		return facId;
	}
	public void setFacid(int facid) {
		this.facId = facid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMembercost() {
		return memberCost;
	}
	public void setMembercost(int membercost) {
		this.memberCost = membercost;
	}
	public int getGuestcost() {
		return guestCost;
	}
	public void setGuestcost(int guestcost) {
		this.guestCost = guestcost;
	}
	public int getInitialoutlay() {
		return initialOutlay;
	}
	public void setInitialoutlay(int initialoutlay) {
		this.initialOutlay = initialoutlay;
	}
	public int getMonthlymaintenance() {
		return monthlyMaintenance;
	}
	public void setMonthlymaintenance(int monthlymaintenance) {
		this.monthlyMaintenance = monthlymaintenance;
	}

	
}
