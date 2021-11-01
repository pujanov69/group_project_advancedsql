package com.dci.advancedsql.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.advancedsql.model.Booking;
import com.dci.advancedsql.model.Facility;
import com.dci.advancedsql.model.Member;
import com.dci.advancedsql.service.QueryService;

@Service
public class QueryServiceImpl implements QueryService{

	@Autowired
	Statement statement;
	
	
	//retrieve all the information from the cd.facilities table
	@Override
	public List<Facility> queryOne() throws SQLException {
		List<Facility> facilities = new ArrayList<>();
		String query = "SELECT * FROM cd.facilities";
		ResultSet resultSet = statement.executeQuery(query);
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
        for(int i = 1; i <= columnCount; i++) {
            header += metadata.getColumnName(i);
            while (header.length() < i * 30) {
                header += " ";
            }
        }
        System.out.print(header);
		System.out.println();
		
		while (resultSet.next()) {
			int facid = resultSet.getInt("facid");
			String name = resultSet.getString("name");
			int membercost = resultSet.getInt("membercost");
			int guestcost = resultSet.getInt("guestcost");
			int initialoutlay = resultSet.getInt("initialoutlay");
			int monthlymaintenance = resultSet.getInt("monthlymaintenance");
			
			Facility facility = new Facility(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance);
			
			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				 row += resultSet.getString(i);
	                
	             while (row.length() < i * 30) {
	                    row += " ";
	              }
			}
			System.out.println(row);
			
			facilities.add(facility);
		}
		return facilities;
	}


	@Override
	public List<Facility> queryTwo() throws SQLException {
		List<Facility> facilities = new ArrayList<>();
		String query = "SELECT name, membercost FROM cd.facilities";
		ResultSet resultSet = statement.executeQuery(query);
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
        for(int i = 1; i <= columnCount; i++) {
            header += metadata.getColumnName(i);
            while (header.length() < i * 30) {
                header += " ";
            }
        }
        System.out.print(header);
		System.out.println();
		
		while (resultSet.next()) {
			String name = resultSet.getString("name");
			int membercost = resultSet.getInt("membercost");
			
			Facility facility = new Facility();
			facility.setName(name);
			facility.setMembercost(membercost);
			

			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				 row += resultSet.getString(i);
	                
	                while (row.length() < i * 30) {
	                    row += " ";
	                }
			}
			System.out.println(row);
			
			facilities.add(facility);
		}
		return facilities;
	}


	//list of facilities that charge a fee to members
	@Override
	public List<Facility> queryThree() throws SQLException {
		List<Facility> facilities = new ArrayList<>();
		String query = "SELECT * FROM cd.facilities WHERE membercost > 0";
		ResultSet resultSet = statement.executeQuery(query);
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
        for(int i = 1; i <= columnCount; i++) {
            header += metadata.getColumnName(i);
            while (header.length() < i * 30) {
                header += " ";
            }
        }
        System.out.print(header);
		System.out.println();
		while (resultSet.next()) {
			int facid = resultSet.getInt("facid");
			String name = resultSet.getString("name");
			int membercost = resultSet.getInt("membercost");
			int guestcost = resultSet.getInt("guestcost");
			int initialoutlay = resultSet.getInt("initialoutlay");
			int monthlymaintenance = resultSet.getInt("monthlymaintenance");
			
			Facility facility = new Facility(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance);
			
			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				 row += resultSet.getString(i);
	                
	                while (row.length() < i * 30) {
	                    row += " ";
	                }
			}
			System.out.println(row);
			
			facilities.add(facility);
		}
		return facilities;
	}


	@Override
	public List<Facility> queryFour() throws SQLException {
		List<Facility> facilities = new ArrayList<>();
		String query = "SELECT facid, name, membercost, monthlymaintenance FROM cd.facilities WHERE membercost > 0 AND (membercost < monthlymaintenance/50.0)";
		ResultSet resultSet = statement.executeQuery(query);
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
        for(int i = 1; i <= columnCount; i++) {
            header += metadata.getColumnName(i);
            while (header.length() < i * 30) {
                header += " ";
            }
        }
        System.out.print(header);
		System.out.println();
		
		while (resultSet.next()) {
			int facid = resultSet.getInt("facid");
			String name = resultSet.getString("name");
			int membercost = resultSet.getInt("membercost");
			int monthlymaintenance = resultSet.getInt("monthlymaintenance");
			
			Facility facility = new Facility();
			facility.setFacid(facid);
			facility.setName(name);
			facility.setMembercost(membercost);
			facility.setMonthlymaintenance(monthlymaintenance);
			
			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				row += resultSet.getString(i);
                
                while (row.length() < i * 30) {
                    row += " ";
                }
			}
			System.out.println(row);
			
			facilities.add(facility);
		}
		return facilities;
	}


	@Override
	public List<Facility> queryFive() throws SQLException {
		List<Facility> facilities = new ArrayList<>();
		String query = "SELECT * FROM cd.facilities WHERE name LIKE '%Tennis%'";
		ResultSet resultSet = statement.executeQuery(query);
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
		for(int i = 1; i <= columnCount; i++) {
			header += metadata.getColumnName(i);
            while (header.length() < i * 30) {
                header += " ";
            }
		}
		System.out.print(header);
		System.out.println();
		
		while (resultSet.next()) {
			int facid = resultSet.getInt("facid");
			String name = resultSet.getString("name");
			int membercost = resultSet.getInt("membercost");
			int guestcost = resultSet.getInt("guestcost");
			int initialoutlay = resultSet.getInt("initialoutlay");
			int monthlymaintenance = resultSet.getInt("monthlymaintenance");
			
			Facility facility = new Facility(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance);
			
			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				row += resultSet.getString(i);
                
                while (row.length() < i * 30) {
                    row += " ";
                }
			}
			System.out.println(row);
			
			facilities.add(facility);
		}
		return facilities;
	}
	
	@Override
	public List<Facility> querySix() throws SQLException {
		List<Facility> facilities = new ArrayList<>();
		String query = "SELECT * FROM cd.facilities WHERE facid IN (1,5)";
		ResultSet resultSet = statement.executeQuery(query);
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
		for(int i = 1; i <= columnCount; i++) {
			header += metadata.getColumnName(i);
			 while (header.length() < i * 30) {
	                header += " ";
	            }
		}
		System.out.print(header);
		System.out.println();
		
		while (resultSet.next()) {
			int facid = resultSet.getInt("facid");
			String name = resultSet.getString("name");
			int membercost = resultSet.getInt("membercost");
			int guestcost = resultSet.getInt("guestcost");
			int initialoutlay = resultSet.getInt("initialoutlay");
			int monthlymaintenance = resultSet.getInt("monthlymaintenance");
			
			Facility facility = new Facility(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance);
			
			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				row += resultSet.getString(i);
				 while (row.length() < i * 30) {
	                    row += " ";
	                }
			}
			System.out.println(row);
			
			facilities.add(facility);
		}
		return facilities;
	}


	@Override
	public List<Member> querySeven() throws SQLException {
		List<Member> members = new ArrayList<>();
		String query = "SELECT memid, surname, firstname, joindate FROM cd.members WHERE joindate >= '2012-09-01'";
		ResultSet resultSet = statement.executeQuery(query);
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
		for(int i = 1; i <= columnCount; i++) {
			header += metadata.getColumnName(i);
			while (header.length() < i * 30) {
				header += " ";
			}
		}
		System.out.print(header);
		System.out.println();
		
		while (resultSet.next()) {
			int memid = resultSet.getInt("memid");
			String surname = resultSet.getString("surname");
			String firstname = resultSet.getString("firstname");
			Date joindate = resultSet.getDate("joindate");
			
			Member member = new Member();
			
			member.setMemId(memid);
			member.setSurName(surname);
			member.setFirstName(firstname);
			member.setJoinDate(joindate);
			
			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				row += resultSet.getString(i);
				
				while (row.length() < i * 30) {
					row += " ";
				}
				
			}
			System.out.println(row);
			
			members.add(member);
		}
		return members;
	}


	@Override
	public List<Member> queryEight() throws SQLException {

		List<Member> members = new ArrayList<>();
		String query = "SELECT DISTINCT surname from cd.members ORDER BY surname LIMIT 10";
		ResultSet resultSet = statement.executeQuery(query);
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
		for(int i = 1; i <= columnCount; i++) {
			header += metadata.getColumnName(i);
			while (header.length() < i * 30) {
				header += " ";
			}
		}
		System.out.print(header);
		System.out.println();
		
		while (resultSet.next()) {
			String surname = resultSet.getString("surname");
			
			Member member = new Member();
			
			member.setSurName(surname);
			
			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				row += resultSet.getString(i);
				
				while (row.length() < i * 30) {
					row += " ";
				}
				
			}
			System.out.println(row);
			
			members.add(member);
		}
		return members;
	}


	@Override
	public Date queryNine() throws SQLException {
		String query = "SELECT MAX(joindate) AS latest_signup FROM cd.members";
		ResultSet resultSet = statement.executeQuery(query);
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
		for(int i = 1; i <= columnCount; i++) {
			header += metadata.getColumnName(i);
			while (header.length() < i * 30) {
				header += " ";
			}
		}
		System.out.print(header);
		System.out.println();
		
		Date latestSignup = null ;
		
		while (resultSet.next()) {
			latestSignup = resultSet.getDate("latest_signup");
			
			System.out.println(latestSignup);
			
		}
		return latestSignup;
	}


	@Override
	public int queryTen() throws SQLException {
		String query = "SELECT COUNT(*) as rowcount FROM cd.facilities WHERE guestcost >= 10";
		ResultSet resultSet = statement.executeQuery(query);
		
		resultSet.next();
		int count = resultSet.getInt("rowcount");
		
		return count;
	}


	@Override
	public List<Booking> queryEleven() throws SQLException {
		
		List<Booking> bookings = new ArrayList<>();
		String query = "SELECT facid, SUM(slots) as total_slots FROM cd.bookings where starttime >= '2012-09-01' and starttime < '2012-10-01' GROUP BY facid ORDER BY total_slots";
		ResultSet resultSet = statement.executeQuery(query);
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
		for(int i = 1; i <= columnCount; i++) {
			header += metadata.getColumnName(i);
			while (header.length() < i * 30) {
				header += " ";
			}
		}
		System.out.print(header);
		System.out.println();
		
		while (resultSet.next()) {
			int totalSlots = resultSet.getInt("total_slots");
			int facilityId = resultSet.getInt("facid");
			
			Booking booking = new Booking();
			
			booking.setFacId(facilityId);
			booking.setSlots(totalSlots);
			
			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				row += resultSet.getString(i);
				
				while (row.length() < i * 30) {
					row += " ";
				}
				
			}
			System.out.println(row);
			
			bookings.add(booking);
		}
		return bookings;
	}


	@Override
	public List<Map<String, Integer>> queryTwelve() throws SQLException {
		String query = "SELECT facid, SUM(slots) as total_slots FROM cd.bookings GROUP BY facid HAVING SUM(slots) > 1000 ORDER BY facid";
		ResultSet resultSet = statement.executeQuery(query);
		
		List<Map<String, Integer>> list = new ArrayList<>();
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
		for(int i = 1; i <= columnCount; i++) {
			header += metadata.getColumnName(i);
			while (header.length() < i * 30) {
				header += " ";
			}
		}
		System.out.print(header);
		System.out.println();
		
		while (resultSet.next()) {
			int facid = resultSet.getInt("facid");
			int totalSlots = resultSet.getInt("total_slots");
			
			Map<String, Integer> map = new HashMap<>();
			map.put("facId", facid);
			map.put("totalSlots", totalSlots);
			
			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				row += resultSet.getString(i);
				
				while (row.length() < i * 30) {
					row += " ";
				}
				
			}
			System.out.println(row);
			
			list.add(map);
		}
		return list;
	}


	@Override
	public List<Map<String, String>> queryThirteen() throws SQLException {
		String query = "SELECT b.starttime AS start, f.name as name FROM cd.bookings b inner join cd.facilities f on b.facid = f.facid where b.facid IN (0,1) AND b.starttime >= '2012-09-21' AND b.starttime < '2012-09-22' ORDER BY starttime";
		ResultSet resultSet = statement.executeQuery(query);
		
		List<Map<String, String>> list = new ArrayList<>();
		
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
		for(int i = 1; i <= columnCount; i++) {
			header += metadata.getColumnName(i);
			while (header.length() < i * 30) {
				header += " ";
			}
		}
		System.out.print(header);
		System.out.println();
		
		while (resultSet.next()) {
			String start = resultSet.getString("start");
			String name = resultSet.getString("name");
			
			Map<String, String> map = new HashMap<>();
			map.put("start", start);
			map.put("name", name);
			
			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				row += resultSet.getString(i);
				
				while (row.length() < i * 30) {
					row += " ";
				}
				
			}
			System.out.println(row);
			
			list.add(map);
		}
		return list;
	}


	@Override
	public List<Date> queryFourteen() throws SQLException {
		String query = "SELECT cd.bookings.starttime FROM cd.bookings INNER JOIN cd.members ON cd.members.memid = cd.bookings.memid WHERE cd.members.firstname='David' AND cd.members.surname='Farrell'";
		ResultSet resultSet = statement.executeQuery(query);
		
		
		List<Date> dates = new ArrayList<>();
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
		for(int i = 1; i <= columnCount; i++) {
			header += metadata.getColumnName(i);
			while (header.length() < i * 30) {
				header += " ";
			}
		}
		System.out.print(header);
		System.out.println();
		
		while (resultSet.next()) {
			Date startTime = resultSet.getDate("starttime");
			
			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				row += resultSet.getString(i);
				
				while (row.length() < i * 30) {
					row += " ";
				}
				
			}
			System.out.println(row);
			
			dates.add(startTime);
		}
		return dates;
	}


	@Override
	public List<Date> queryFifteen() throws SQLException {
		String query = "select starttime from cd.bookings where memid = (SELECT memid from cd.members where firstname like 'David' AND surname like 'Farrell')";
		ResultSet resultSet = statement.executeQuery(query);
		
		
		List<Date> dates = new ArrayList<>();
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		int columnCount = metadata.getColumnCount();
		String header = "";
		for(int i = 1; i <= columnCount; i++) {
			header += metadata.getColumnName(i);
			while (header.length() < i * 30) {
				header += " ";
			}
		}
		System.out.print(header);
		System.out.println();
		
		while (resultSet.next()) {
			Date startTime = resultSet.getDate("starttime");
			
			String row = "";
			for(int i = 1; i <= columnCount; i++) {
				row += resultSet.getString(i);
				
				while (row.length() < i * 30) {
					row += " ";
				}
				
			}
			System.out.println(row);
			
			dates.add(startTime);
		}
		return dates;
	}

}
