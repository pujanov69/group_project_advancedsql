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
	
	
	//1. How can you retrieve all the information from the cd.facilities table?
	
	@Override
	public List<Facility> queryOne() throws SQLException {
		List<Facility> facilities = new ArrayList<>();
		
		// write the query 
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
			//change the column names as per the column names in the query if needed.
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


	//2. You want to print out a list of all of the facilities and their cost to members. How would you retrieve a list of only facility names and costs?
	
	@Override
	public List<Facility> queryTwo() throws SQLException {
		//to be implemented
		return null;
	}


	//3. How can you produce a list of facilities that charge a fee to members?
	@Override
	public List<Facility> queryThree() throws SQLException {
		//to be implemented
		return null;
	}


	//4. How can you produce a list of facilities that charge a fee to members, and that fee is less than 1/50th of the monthly maintenance cost? Return the facid, facility name, member cost, and monthly maintenance of the facilities in question.
	@Override
	public List<Facility> queryFour() throws SQLException {
		//to be implemented
		return null;
	}


	//5. How can you produce a list of all facilities with the word 'Tennis' in their name?
	@Override
	public List<Facility> queryFive() throws SQLException {
		//to be implemented
		return null;
	}
	
	//6. How can you retrieve the details of facilities with ID 1 and 5? Try to do it without using the OR operator.
	@Override
	public List<Facility> querySix() throws SQLException {
		//to be implemented
		return null;
	}


	//7. How can you produce a list of members who joined after the start of September 2012? Return the memid, surname, firstname, and joindate of the members in question.
	@Override
	public List<Member> querySeven() throws SQLException {
		//to be implemented
		return null;
	}


	//8. How can you produce an ordered list of the first 10 surnames in the members table? The list must not contain duplicates.
	@Override
	public List<Member> queryEight() throws SQLException {
		//to be implemented
		return null;
	}


	//9. You'd like to get the signup date of your last member. How can you retrieve this information
	@Override
	public Date queryNine() throws SQLException {
		//to be implemented
		return null;
	}


	//10. Produce a count of the number of facilities that have a cost to guests of 10 or more.
	@Override
	public int queryTen() throws SQLException {
		//to be implemented
		return 0;
	}


	//11. Produce a list of the total number of slots booked per facility in the month of September 2012. Produce an output table consisting of facility id and slots, sorted by the number of slots.
	@Override
	public List<Booking> queryEleven() throws SQLException {
		//to be implemented
		return null;
	}


	//12. Produce a list of facilities with more than 1000 slots booked. Produce an output table consisting of facility id and total slots, sorted by facility id.
	@Override
	public List<Map<String, Integer>> queryTwelve() throws SQLException {
		//to be implemented
		return null;
	}


	//13. How can you produce a list of the start times for bookings for tennis courts, for the date '2012-09-21'? Return a list of start time and facility name pairings, ordered by the time. 
	@Override
	public List<Map<String, String>> queryThirteen() throws SQLException {
		//to be implemented
		return null;
	}


	//14. How can you produce a list of the start times for bookings by members named 'David Farrell'? (Use Inner Join)
	@Override
	public List<Date> queryFourteen() throws SQLException {
		//to be implemented
		return null;
	}

	//15. How can you produce a list of the start times for bookings by members named 'David Farrell'? (Use Sub-query)
	@Override
	public List<Date> queryFifteen() throws SQLException {
		//to be implemented
		return null;
	}

}
