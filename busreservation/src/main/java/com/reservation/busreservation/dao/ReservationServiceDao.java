package com.reservation.busreservation.dao;

import java.util.List;

import com.reservation.busreservation.exception.ReservationException;
import com.reservation.busreservation.model.SearchResults;


public interface ReservationServiceDao {
	public List<SearchResults> getSearchResult(String source, String destination, String travelDate, String returnDate) throws ReservationException;		
	

}
