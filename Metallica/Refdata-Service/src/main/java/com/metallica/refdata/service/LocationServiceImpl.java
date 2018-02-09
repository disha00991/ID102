package com.metallica.refdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metallica.refdata.model.Location;
import com.metallica.refdata.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public List<Location> getAllLocation() {
		return locationRepository.findAll();
	}

}
