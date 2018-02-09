package com.metallica.trade.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metallica.trade.model.Market;
import com.metallica.trade.model.Side;
import com.metallica.trade.model.Trade;
import com.metallica.trade.model.TradeStatus;
import com.metallica.trade.repository.MarketRepository;
import com.metallica.trade.repository.TradeRepository;


@Service
@Transactional
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;
	
	@Autowired
	private EntityManager em;

	@Autowired
	private MarketRepository marketRepository;

	@Autowired
	RabbitMQSenderNotification rabbitMQSenderForNotification;

	@Override
	public Trade getTradesById(long id) {
		return tradeRepository.findOne(id);
	}

	@Override
	public List<Trade> getAllTrades() {
		return tradeRepository.findAll();
	}

	@Override
	public Trade createTrade(Trade trade) {
		System.out.println("----------------------- saving trade ----------------------- " + trade);
		Trade newTrade = tradeRepository.save(trade);
		rabbitMQSenderForNotification.send("Trade "+trade.getId()+" Created Successfully...");
		return newTrade;
	}

	@Override
	public List<Trade> deleteTradeById(long id) {
		System.out.println("----------------------- deleting trade ----------------------- " + id);
		Trade trade = getTradesById(id);
		tradeRepository.delete(id);
		rabbitMQSenderForNotification.send("Trade "+trade.getId()+" Deleted Successfully...");
		return tradeRepository.findAll();
	}

	@Override
	public List<Trade> updateTrade(Trade trade) {
		System.out.println("----------------------- updating trade ----------------------- " + trade);
		tradeRepository.save(trade);
		rabbitMQSenderForNotification.send("Trade "+trade.getId()+" Updated Successfully..");
		return tradeRepository.findAll();
	}

	@Override
	public List<Trade> searchTradesByCounterparty(String search) {
//		Counterparty counterparty = counterPartyRepository.findByName(search);
		return tradeRepository.findByCounterparty(search);
	}

	@Override
	public List<Trade> searchTradesByCommodity(String search) {
//		Commodity commodity = commodityRepository.findByName(search);
		return tradeRepository.findByCommodity(search);
	}

	@Override
	public List<Trade> searchTradesByLocation(String search) {
//		Location location = locationRepository.findByName(search);
		return tradeRepository.findByLocation(search);
	}

	@Override
	public List<Trade> searchTrade(String startDate, String endDate, String location, String commodity,
			String counterparty, String buyside, String sellside) throws ParseException {
		
		
//		List<Trade> trade = tradeRepository.findAll();
//		if (!startDate.equals("default") && !endDate.equals("default")) {
//
//			Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
//			Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
//			trade = tradeRepository.findByTradeDateBetween(dateStart, dateEnd);
//
//		} else if (startDate.equals("default") && !endDate.equals("default")) {
//
//			Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
//			trade = tradeRepository.findByTradeDateBefore(dateEnd);
//
//		} else if (!startDate.equals("default") && endDate.equals("default")) {
//
//			Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
//			trade = tradeRepository.findByTradeDateAfter(dateStart);
//
//		}
//		System.out.println(trade);
//		
//		List<Trade> trades = trade.parallelStream().filter(t -> {
//			if (!location.equals("default")) {
////				System.out.println(t.getLocation());
////				System.out.println(location);
////				System.out.println( location.equals(t.getLocation()));
//					return location.equals(t.getLocation());
//			} else
//				return true;
//		}).filter(t -> {
//			if (!commodity.equals("default")) {
////				if (commodity != null)
//					return commodity.equals(t.getCommodity());
////				return false;
//			} else
//				return true;
//		}).filter(t -> {
//			if (!counterparty.equals("default")) {
////				if (counterparty != null)
//					return counterparty.equals(t.getCounterparty());
////				else
////					return false;
//			} else
//				return true;
//		})
//			.filter(t -> {
//			if (!buyside.equals("default") && sellside.equals("default")) {
//				System.out.println(t.getSide());
//				return t.getSide().toString().equals(buyside);
//			} else
//				return true;
//
//		}).filter(t -> {
//			if (!sellside.equals("default") && buyside.equals("default")) {
//				return t.getSide().toString().equals(sellside);
//			} else
//				return true;
//		}).collect(Collectors.toList());
//
//		return trades;
		
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery cq = qb.createQuery();
		Root<Trade> trade = cq.from(Trade.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (!location.equals("default")) {
			predicates.add(qb.equal(trade.get("location"), location));
		}

		if (!commodity.equals("default")) {
			predicates.add(qb.equal(trade.get("commodity"), commodity));
		}
		if (!counterparty.equals("default")) {
			predicates.add(qb.equal(trade.get("counterparty"), counterparty));
		}
		
		if (!startDate.equals("default")) {
			Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			predicates.add((Predicate) qb.greaterThanOrEqualTo(trade.get("tradeDate"), dateStart));
		}
		
		if (!endDate.equals("default")) {
			Date dateEnd=new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			predicates.add((Predicate) qb.lessThanOrEqualTo(trade.get("tradeDate"), dateEnd));
		}
		if (!buyside.equals("default") && sellside.equals("default")) {
			predicates.add((Predicate) qb.equal(trade.get("side"), Side.BUY));
		
		}if (!sellside.equals("default") && buyside.equals("default")) {
			predicates.add((Predicate) qb.equal(trade.get("side"), Side.SELL));
		}

		// query itself
		cq.select(trade).where(predicates.toArray(new Predicate[] {}));
		// execute query and do something with result
		List<Trade> tradeList = em.createQuery(cq).getResultList();

		return tradeList;
	}

	@Override
	public List<Trade> findByTraderId(long id) {
		return tradeRepository.findByTrader(id);
	}

	@Override
	public List<Trade> findTradeExceptTrader(long id) {
		return tradeRepository.findByTraderNotIn(id);
	}

	@Override
	public void matchTrade() {
		Timer t = new Timer();

		t.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				List<Trade> openTrades = tradeRepository.findByStatus(TradeStatus.OPEN);
				for (Trade trade : openTrades) {
					Market market = marketRepository.findByName(trade.getCommodity());
					if (trade.getPrice() == market.getPrice()) {
						trade.setStatus(TradeStatus.NOMINATED);
						updateTrade(trade);
						rabbitMQSenderForNotification.send("Trade "+trade.getId()+" Matched and Nominated Successfully...");
					}
				}
			}
		}, 0, // run first occurrence immediatetly
				20000);
	}

}