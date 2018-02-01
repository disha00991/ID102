package com.myapp.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.myapp.spring.model.Trade;
import com.myapp.spring.refData.model.Location;



public interface LocationRepository extends JpaRepository<Location, Long>,JpaSpecificationExecutor<Location>{
	
	List<Location> findAll();
	Location findByName(String name);
	Location findBySymbol(String symbol);
}
