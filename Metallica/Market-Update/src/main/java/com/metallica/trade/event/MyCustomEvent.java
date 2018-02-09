package com.metallica.trade.event;

import java.util.List;

import org.springframework.context.ApplicationEvent;

import com.metallica.trade.models.Market;

public class MyCustomEvent extends ApplicationEvent {
	
	private List<Market> markets;

	public MyCustomEvent(Object source,List<Market> markets) {
		super(source);   
		this.markets=markets; 
	}

	public List<Market> getMarkets() {
		return markets;
	}
	


}
