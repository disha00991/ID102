package com.myapp.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.hibernate.model.FlightDetails;
import com.myapp.spring.repository.FlightRepository;

@RestController // no need to take care of view resolver. Only JSON data is returned using
				// "REST" .this converts object to json and back
public class FlightController {

	@Autowired
	private FlightRepository flightService;

	// encapsulating the response into an object
	//http://localhost:8081/spring-mvc/flights
	@RequestMapping(value = "/flights", method = RequestMethod.GET)
	public ResponseEntity<List<FlightDetails>> getAllFlights() {
		return new ResponseEntity<List<FlightDetails>>(flightService.findAll(), HttpStatus.OK);
	}

	// implemented in orderRepository
	// http://localhost:8081/spring-mvc/flights/find?sourceCity=?&destinationCity=?&sortBy=?
	@RequestMapping(value = "/flights/find", method = RequestMethod.GET)
	public ResponseEntity<List<FlightDetails>> findBySourceCityAndDestinationCity(
			@RequestParam("sourceCity") String sourceCity,
			@RequestParam("destinationCity") String destinationCity,
			@RequestParam("sortBy") String sortBy) {

		List<FlightDetails> availableFlights = new ArrayList<>();
		availableFlights = flightService.findBySourceCityAndDestinationCity(sourceCity, destinationCity);
		
		// sorting
		if(sortBy.equalsIgnoreCase("f"))
		{
			availableFlights = availableFlights.stream()
			.sorted((f1, f2)-> Double.compare(f1.getFare(), f2.getFare()))
			.collect(Collectors.toList());
		}
		else if(sortBy.equalsIgnoreCase("d"))
		{
			availableFlights = availableFlights.stream()
			.sorted((f1, f2)-> Double.compare(f1.getDuration(), f2.getDuration()))
			.collect(Collectors.toList());
		}
		else if(sortBy.equalsIgnoreCase("fnd"))
		{
			availableFlights = availableFlights.stream()
			.sorted((f1, f2)-> {
				if(f1.getFare() == f2.getFare())
					return Double.compare(f1.getDuration(), f2.getDuration());
				else
					return Double.compare(f1.getFare(), f2.getFare());
			})
			.collect(Collectors.toList());
		}

		return new ResponseEntity<List<FlightDetails>>(availableFlights, HttpStatus.OK);
	}

}
