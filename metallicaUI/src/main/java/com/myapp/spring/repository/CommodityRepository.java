package com.myapp.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.myapp.spring.model.Trade;
import com.myapp.spring.refData.model.Commodity;



public interface CommodityRepository extends JpaRepository<Commodity, Long>,JpaSpecificationExecutor<Commodity>{
	
	List<Commodity> findAll();
	Commodity findByName(String name);
	Commodity findBySymbol(String symbol);
	Commodity findById(long id);
}
