package com.dci.advancedsql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dci.advancedsql.model.Booking;
import com.dci.advancedsql.model.Facility;
import com.dci.advancedsql.model.Member;
import com.dci.advancedsql.service.QueryService;

@SpringBootTest
class AdvancedsqlApplicationTests {

	@Autowired
	QueryService queryService;
	
	@Test
	void queryOneTest() throws SQLException {
		List<Facility> results = queryService.queryOne();
		assertEquals(9, results.size());
	}
	
	@Test
	void queryTwoTest() throws SQLException {
		List<Facility> results = queryService.queryTwo();
		assertEquals(9, results.size());
		
		for(Facility facility : results) {
			assertEquals(0, facility.getFacid());
			assertEquals(0, facility.getGuestcost());
			assertEquals(0, facility.getInitialoutlay());
			assertEquals(0, facility.getMonthlymaintenance());
			
			assertNotNull(facility.getName());
		}
	}
	
	//list of facilities that charge a fee to members
	@Test
	void queryThreeTest() throws SQLException {
		List<Facility> results = queryService.queryThree();
		assertEquals(5, results.size());
		
		for(Facility facility : results) {	
			assertTrue(facility.getMembercost() > 0);
		}
	}
	
	@Test
	void queryFourTest() throws SQLException {
		List<Facility> results = queryService.queryFour();
		assertEquals(2, results.size());
		
		for(Facility facility : results) {	
			assertTrue(facility.getMembercost() > 0 );
			assertTrue(facility.getMembercost() < (facility.getMonthlymaintenance() / 50));
		}
	}
	
	
	@Test
	void queryFiveTest() throws SQLException {
		List<Facility> results = queryService.queryFive();
		assertEquals(3, results.size());
		
		for(Facility facility : results) {	
			assertTrue(facility.getName().contains("Tennis"));
		}
	}
	
	@Test
	void querySixTest() throws SQLException {
		List<Facility> results = queryService.querySix();
		assertEquals(2, results.size());
		
		for(Facility facility : results) {	
			assertTrue(facility.getFacid() == 1 || facility.getFacid() == 5);
		}
	}
	
	@Test
	void querySevenTest() throws SQLException, ParseException {
		List<Member> results = queryService.querySeven();
		assertEquals(10, results.size());
		
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdformat.parse("2012-09-01");
		for(Member member : results) {	
			assertTrue(member.getJoinDate().compareTo(d1) >= 0);
		}
	}

	@Test
	void queryEightTest() throws SQLException, ParseException {
		List<Member> results = queryService.queryEight();
		assertEquals(10, results.size());
		
		String surname = "";
		for(Member member : results) {
			assertTrue(member.getSurName().toLowerCase().compareTo(surname.toLowerCase()) > 0);
			surname = member.getSurName();
		}
	}
	
	@Test
	void queryNineTest() throws SQLException, ParseException {
		Date result = queryService.queryNine();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdformat.parse("2012-09-26");
		
		assertTrue(result.compareTo(d1) == 0);		
	}
	
	
	@Test
	void queryTenTest() throws SQLException, ParseException {
		int result = queryService.queryTen();
		
		assertEquals(6,result);		
	}
	
	@Test
	void queryElevenTest() throws SQLException, ParseException {
		List<Booking> results = queryService.queryEleven();		
		assertEquals(9,results.size());		
		
		List<Integer> list = Arrays.asList(122, 422, 426, 471, 540, 570, 588, 591, 648);
		
		int slots = 0;
		for(Booking booking : results) {
			assertTrue(booking.getSlots() > slots);
			slots = booking.getSlots();
			
			assertTrue(list.contains(booking.getSlots()));
		}
	}
	
	@Test
	void queryTwelveTest() throws SQLException, ParseException {
		List<Map<String, Integer>> results = queryService.queryTwelve();		
		assertEquals(5,results.size());		
		
		int facid = -1;
		
		for(Map<String, Integer> map : results) {
			assertTrue(map.get("totalSlots") > 1000);
			
			assertTrue(map.get("facId") > facid);
			facid = map.get("facId");
		}
	}
	
	@Test
	void queryThirteenTest() throws SQLException, ParseException {
		List<Map<String, String>> results = queryService.queryThirteen();		
		assertEquals(12,results.size());		
		
		
		for(Map<String, String> map : results) {
			assertTrue(map.get("name").contains("Tennis"));
			assertTrue(map.get("start").contains("2012-09-21"));
		}
	}
	
	@Test
	void queryFourteenTest() throws SQLException, ParseException {
		List<Date> results = queryService.queryFourteen();		
		assertEquals(34,results.size());		
	}
	
	@Test
	void queryFifteenTest() throws SQLException, ParseException {
		List<Date> results = queryService.queryFifteen();		
		assertEquals(34,results.size());		
	}
	
}
