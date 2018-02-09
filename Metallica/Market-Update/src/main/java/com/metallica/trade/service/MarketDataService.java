package com.metallica.trade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.metallica.trade.models.Market;
import com.metallica.trade.repository.MarketRepository;

@Service
public class MarketDataService {

	private static int count = 0;
	private static boolean incrementFlag = false;

	@Autowired
	private MarketRepository repo;

	// Function to update the market prices
	@Scheduled(fixedDelay = 20000L)
	public void startMarketDataUpdate() {

		// data contains all the prices of all commodities
		List<Market> data = repo.findAll();

		for (Market mktData : data) {
			if (incrementFlag) {
				double currentPrice = mktData.getPrice();
				mktData.setPrice((int)(currentPrice + currentPrice * 0.05));
				repo.save(mktData);
			} else {
				double currentPrice = mktData.getPrice();
				mktData.setPrice((int)(currentPrice - currentPrice * 0.05));
				repo.save(mktData);
			}
		}
		count += 1;
		if (count % 5 == 0) {
			incrementFlag = !incrementFlag;
		}
	}
}
