package com.myapp.spring;

import java.util.List;

import com.myapp.spring.Flight;

public interface FlightDAO {
	List<Flight> findAll();
}
