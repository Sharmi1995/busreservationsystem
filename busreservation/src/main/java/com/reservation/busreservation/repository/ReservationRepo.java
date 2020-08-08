package com.reservation.busreservation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.busreservation.model.SearchResults;

@Repository
public interface ReservationRepo extends CrudRepository<SearchResults, Integer> {
	
	Iterable<SearchResults> findAllById(Iterable<Integer> ids);

}
