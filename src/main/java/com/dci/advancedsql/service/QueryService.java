package com.dci.advancedsql.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dci.advancedsql.model.Booking;
import com.dci.advancedsql.model.Facility;
import com.dci.advancedsql.model.Member;

public interface QueryService {

	public List<Facility> queryOne() throws SQLException;
	public List<Facility> queryTwo() throws SQLException;
	public List<Facility> queryThree() throws SQLException;
	public List<Facility> queryFour() throws SQLException;
	public List<Facility> queryFive() throws SQLException;
	public List<Facility> querySix() throws SQLException;
	
	public List<Member> querySeven() throws SQLException;
	public List<Member> queryEight() throws SQLException;
	public Date queryNine() throws SQLException;
	public int queryTen() throws SQLException;
	
	public List<Booking> queryEleven() throws SQLException;
	
	public List<Map<String, Integer>> queryTwelve() throws SQLException;
	public List<Map<String, String>> queryThirteen() throws SQLException;
	public List<Date> queryFourteen() throws SQLException;
	public List<Date> queryFifteen() throws SQLException;
}
