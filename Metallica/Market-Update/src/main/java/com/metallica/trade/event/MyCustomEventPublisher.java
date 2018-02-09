package com.metallica.trade.event;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.metallica.trade.models.Market;
import com.metallica.trade.producer.Producer;
import com.metallica.trade.repository.MarketRepository;

@Component
public class MyCustomEventPublisher implements ApplicationEventPublisherAware{
    
	protected ApplicationEventPublisher aea;
	
	@Autowired
	private MarketRepository repository;
	
	@Autowired
	private Producer producer;
	
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher aea) {
		this.aea=aea;
	}
	
	@Scheduled(fixedRate=10000L) //notifying subscriber after every 3 sec
	public void publishEvents() {
		final List<Market> markets=repository.findAll();
		producer.produce(markets);
		final MyCustomEvent event=new MyCustomEvent(this, markets); 
		aea.publishEvent(event);
	}
  
}
