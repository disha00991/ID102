package com.metallica.trade.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.metallica.trade.model.Trader;



public interface TraderRepository extends JpaRepository<Trader, Long>,JpaSpecificationExecutor<Trader> {
	Trader findById(long id);
	
	 Optional<Trader> findByUsername(String username);
}
