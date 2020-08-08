package com.reservation.busreservation.contoller;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.naming.directory.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.reservation.busreservation.exception.ReservationException;
import com.reservation.busreservation.model.SearchResults;
import com.reservation.busreservation.service.ReservationService;

@RestController
public class BusReservationController {
	
	@Autowired
	ReservationService reservationService;
	
    @RequestMapping(value="/BusReservation",method= RequestMethod.POST)
	public List<SearchResults> BusReservation(@RequestParam String source,@RequestParam String destination,
			@RequestParam String travelDate,@RequestParam String ReturnDate) throws SQLException, ReservationException {
    	List<SearchResults> searchResult = reservationService.getSearchResult(source,destination,travelDate,ReturnDate);
    	System.out.println(searchResult);
		return searchResult;
	}
}
