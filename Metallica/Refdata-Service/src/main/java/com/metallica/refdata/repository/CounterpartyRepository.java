package com.metallica.refdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.metallica.refdata.model.Counterparty;

public interface CounterpartyRepository extends JpaRepository<Counterparty, Long>,JpaSpecificationExecutor<Counterparty>{
	Counterparty findByName(String name);
	Counterparty findBySymbol(String symbol);
}
