package com.metallica.refdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metallica.refdata.model.Commodity;
import com.metallica.refdata.model.Counterparty;
import com.metallica.refdata.model.Location;
import com.metallica.refdata.service.CommodityService;
import com.metallica.refdata.service.CounterpartyService;
import com.metallica.refdata.service.LocationService;

@RestController
public class RefdataController {

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private CounterpartyService counterpartyService;
	
	@GetMapping(value="/location")
	public List<Location> findAllLocation(){
		return locationService.getAllLocation();
	}
	
	@GetMapping(value="/commodity")
	public List<Commodity> findAllCommodity(){
		return commodityService.findAllCommodity();
	}
	
	@GetMapping(value="/counterparty")
	public List<Counterparty> findAllCounterparty(){
		return counterpartyService.findAllCounterparty();
	}
}
