package com.reservation.busreservation.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BusDetails {

	@Id
	private String source;
	
	private String destination;
	
	private String travelDate;
	
	private String ReturnDate;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTravelDate() {
		return travelDate;
	}

	@Override
	public String toString() {
		return "BusDetails [source=" + source + ", destination=" + destination + ", travelDate=" + travelDate
				+ ", ReturnDate=" + ReturnDate + "]";
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}
	
}
