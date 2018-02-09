package com.metallica.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metallica.trade.models.Market;

public interface MarketRepository extends JpaRepository<Market,Long>{

}
