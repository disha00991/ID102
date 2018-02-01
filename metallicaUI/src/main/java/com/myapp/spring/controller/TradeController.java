package com.myapp.spring.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;
import com.myapp.spring.model.Trade;
import com.myapp.spring.refData.model.Commodity;
import com.myapp.spring.refData.model.Counterparty;
import com.myapp.spring.refData.model.Location;
import com.myapp.spring.repository.CommodityRepository;
import com.myapp.spring.repository.CounterpartyRepository;
import com.myapp.spring.repository.LocationRepository;
import com.myapp.spring.repository.ProductRepository;
import com.myapp.spring.repository.TradeRepository;

@RestController
public class TradeController {

	@Autowired
	TradeRepository tradeRepository;
	
	@Autowired
	CommodityRepository commodityRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	CounterpartyRepository counterpartyRepository;

	@RequestMapping(value="/trade", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trade>> getAllTrades() {
		return new ResponseEntity<List<Trade>>(tradeRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value="/commodity", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Commodity>> getAllCommodities() {
		return new ResponseEntity<List<Commodity>>(commodityRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/location", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Location>> getAllLocations() {
		return new ResponseEntity<List<Location>>(locationRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/counterparty", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Counterparty>> getAllCounterParty() {
		return new ResponseEntity<List<Counterparty>>(counterpartyRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/trade/save", produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> saveTrade(@RequestBody Trade trade) {
		System.out.println("hi i ma a good boy");
		tradeRepository.save(trade);
		return new ResponseEntity<String>("Trade has been created", HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/trade/edit", produces = APPLICATION_JSON_VALUE, method=RequestMethod.PUT)
	public ResponseEntity<String> editTrade(@RequestBody Trade trade) {
		tradeRepository.save(trade);
		return new ResponseEntity<String>("Trade has been modified!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/trade", produces = APPLICATION_JSON_VALUE, method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteTrade(@RequestParam("tradeId") long tradeId) {
		tradeRepository.delete(tradeId);
		return new ResponseEntity<String>("Trade has been deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/trade/find", method=RequestMethod.GET)
	public ResponseEntity<Trade> findByTradeId(@RequestParam("tradeId")long tradeId) {
		return new ResponseEntity<Trade>(tradeRepository.findOne(tradeId), HttpStatus.OK);
	}
}
