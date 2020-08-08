package com.reservation.busreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.busreservation.dao.ReservationServiceDao;
import com.reservation.busreservation.exception.ReservationException;
import com.reservation.busreservation.model.SearchResults;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationServiceDao  reservationServiceDao;
	
	@Override
	public List<SearchResults> getSearchResult(String source, String destination, String travelDate, String returnDate) throws ReservationException {
		return reservationServiceDao.getSearchResult(source,destination,travelDate,returnDate);
	}



}
