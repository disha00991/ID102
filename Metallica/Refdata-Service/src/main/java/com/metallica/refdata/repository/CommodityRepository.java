package com.metallica.refdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.metallica.refdata.model.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Long>,JpaSpecificationExecutor<Commodity>{
	Commodity findByName(String name);
	Commodity findBySymbol(String symbol);
}
