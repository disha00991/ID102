package com.metallica.trade.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metallica.trade.model.Trade;
import com.metallica.trade.service.TradeService;

@RestController
public class TradeController {
	@Autowired
	private TradeService tradeService;

//	@Autowired
//	RabbitMQSenderNotification rabbitMQSenderForNotification;

	@GetMapping(path = "/trade")
	public List<Trade> getAllTrades() {
		System.out.println("trade controller: "+tradeService.getAllTrades());
		tradeService.matchTrade();
		return tradeService.getAllTrades();
	}

	@GetMapping(path = "/trade/{id}")
	public Trade getTradeById(@PathVariable long id) {
		return tradeService.getTradesById(id);
	}

	@DeleteMapping(path = "/trade/{id}")
	public List<Trade> deleteTradeById(@PathVariable long id) {
		Trade trade = tradeService.getTradesById(id);
//		rabbitMQSenderForNotification.send("Request Placed for deleting trade " + trade.getId());
		return tradeService.deleteTradeById(id);
	}

	@PutMapping(path = "/trade")
	public List<Trade> updateTradeById(@RequestBody Trade trade) {
//		rabbitMQSenderForNotification.send("Request Placed for updating trade " + trade.getId());
		return tradeService.updateTrade(trade);
	}

	@PostMapping(path = "/trade")
	public Trade createTrade(@RequestBody Trade trade) throws Exception {		
//		rabbitMQSenderForNotification.send("Request Placed for creating trade...");
		return tradeService.createTrade(trade);
	}

	@RequestMapping(value = "/trade/search", params = { "startDate", "endDate", "commodity", "buyside", "sellside",
			"counterparty", "location" })
	public List<Trade> searchTrades(@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate, @RequestParam(value = "commodity") String commodity,
			@RequestParam(value = "buyside") String buyside, @RequestParam(value = "sellside") String sellside,
			@RequestParam(value = "counterparty") String counterparty,
			@RequestParam(value = "location") String location) throws ParseException {

		List<Trade> trades = tradeService.searchTrade(startDate, endDate, location, commodity,
				counterparty, buyside, sellside);
		return trades;
	}

	//TODO: use in form of search query
	@RequestMapping(value = "/trade/findByOne", params = { "id" })
	public List<Trade> findByTraderId(@RequestParam(value = "id") long id) {
		return tradeService.findByTraderId(id);
	}
	
	//TODO: use in form of search query
	@RequestMapping(value = "/trade/findByNone", params = { "id" })
	public List<Trade> findTradeExceptTrader(@RequestParam(value = "id") long id) {
		return tradeService.findTradeExceptTrader(id);
	}
	
	

}
