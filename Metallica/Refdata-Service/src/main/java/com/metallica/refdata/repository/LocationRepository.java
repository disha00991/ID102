package com.metallica.refdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.metallica.refdata.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>,JpaSpecificationExecutor<Location>{
	Location findByName(String name);
	Location findBySymbol(String symbol);
}
