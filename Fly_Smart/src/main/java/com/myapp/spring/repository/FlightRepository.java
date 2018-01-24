package com.myapp.spring.repository;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.myapp.spring.hibernate.model.FlightDetails;

@Repository
public interface FlightRepository extends JpaRepository<FlightDetails, Long> {
	
	List<FlightDetails> findBySourceCityAndDestinationCity(String sourceCity, String destinationCity);
	
	//@Query(name="select o from Order as o JOIN FETCH o.customer")
	//@EntityGraph(value="order.customer.graph", type=EntityGraphType.LOAD)
	List<FlightDetails> findAll();
	
	@Lock(LockModeType.PESSIMISTIC_READ)
	FlightDetails findOne(Long arg0);
}
