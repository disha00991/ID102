package com.metallica.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.metallica.trade.model.Market;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> ,JpaSpecificationExecutor<Market>{

	Market findBySymbol(String symbol);
	Market findByName(String name);
}
