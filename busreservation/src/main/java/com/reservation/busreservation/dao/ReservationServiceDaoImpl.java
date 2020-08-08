package com.reservation.busreservation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.reservation.busreservation.exception.ReservationException;
import com.reservation.busreservation.model.BusDetails;
import com.reservation.busreservation.model.SearchResults;

@Repository
public class ReservationServiceDaoImpl implements ReservationServiceDao {
	
	BusDetails busDetails;
	
	@Autowired
	DataSource dataSource;
	
	
	@Override
	public List<SearchResults> getSearchResult(String source1, String destination1, String travelDate, String returnDate) throws ReservationException {
		
		
		final String NO_BUSES_EXISTS_ERROR = " No Buses available in specified route";
		
		List<SearchResults> searchResults = new ArrayList<SearchResults>();
		 String query =
				 "select * from SEARCH_RESULTS " + "where source=\'"+source1+"\' AND destination=\'"+destination1+"\'";
	    				
	    Statement stmt = null;
	    Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    try {
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	        	SearchResults searchResults1 = new SearchResults();
	        	searchResults1.setOperatorName(rs.getString(6));
	        	searchResults1.setDeparture(rs.getString(4));
	        	searchResults1.setArrival(rs.getString(2));
	        	searchResults1.setBusNumber(rs.getString(3));
	        	searchResults1.setSource(rs.getString(1));
	        	searchResults1.setDestination(rs.getString(5));
	        	searchResults.add(searchResults1);
	        }
	   
	    } 
	    catch (Exception e) {
	    }
	    if(searchResults.isEmpty()) {
	    	throw new ReservationException(NO_BUSES_EXISTS_ERROR);
	    }
		
	    return searchResults; 
		
	}

}
