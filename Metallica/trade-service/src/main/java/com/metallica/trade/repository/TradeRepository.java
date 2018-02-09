package com.metallica.trade.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.metallica.trade.model.Trade;
import com.metallica.trade.model.TradeStatus;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long>,JpaSpecificationExecutor<Trade> {
	 List<Trade> findAll();
	 List<Trade> findByLocation(String name);
	 List<Trade> findByCommodity(String name);
	 List<Trade> findByCounterparty(String name);
	 List<Trade> findByTrader(long id);
	 List<Trade> findByTraderNotIn(long id);
	 List<Trade> findByLocationOrCommodityOrCounterparty(String location,String commodity,String counterparty);
	 List<Trade> findByTradeDateAfter(Date startdate);
	 List<Trade> findByTradeDateBefore(Date endDate);
	 List<Trade> findByTradeDateBetween(Date startDate,Date endDate);
	 List<Trade> findByStatus(TradeStatus open);
}
