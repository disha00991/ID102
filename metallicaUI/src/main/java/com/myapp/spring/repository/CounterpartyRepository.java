package com.myapp.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.myapp.spring.model.Trade;
import com.myapp.spring.refData.model.Counterparty;



public interface CounterpartyRepository extends JpaRepository<Counterparty, Long>,JpaSpecificationExecutor<Counterparty>{
	
	List<Counterparty> findAll();
	Counterparty findByName(String name);
	Counterparty findBySymbol(String symbol);
}
