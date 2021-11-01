package com.dci.advancedsql.model;

import java.util.Date;

public class Booking {

	private int bookId;
	private int facId;
	private int memId;
	private Date startTime;
	private int slots;	
	
	public Booking() {
		super();
	}

	public Booking(int bookId, int facId, int memId, Date startTime, int slots) {
		super();
		this.bookId = bookId;
		this.facId = facId;
		this.memId = memId;
		this.startTime = startTime;
		this.slots = slots;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getFacId() {
		return facId;
	}

	public void setFacId(int facId) {
		this.facId = facId;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getSlots() {
		return slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}
	
	
}
