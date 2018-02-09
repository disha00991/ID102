package com.metallica.trade.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.metallica.trade.model.Trade;

public interface TradeService {
	Trade getTradesById(long id);

	List<Trade> getAllTrades();

	Trade createTrade(Trade trade);

	List<Trade> updateTrade(Trade trade);

	List<Trade> deleteTradeById(long id);

	List<Trade> searchTrade(String startDate, String endDate, String location, String commodity, String counterparty, String buyside,
			String sellside) throws ParseException;

	List<Trade> searchTradesByCounterparty(String search);

	List<Trade> searchTradesByCommodity(String search);

	List<Trade> searchTradesByLocation(String search);
	
	List<Trade> findByTraderId(long id);

	List<Trade> findTradeExceptTrader(long id);
	
	void matchTrade();
}
