package com.metallica.trade.producer;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.metallica.trade.models.Market;


@Component
public class Producer {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${exchange}")
	private String exchange;
	
	@Value("${routingkey}")
	private String routingKey;
	
	public void produce(List<Market> markets){
		amqpTemplate.convertAndSend(exchange, routingKey, markets);
		System.out.println("Send msg = " + markets);
	}
}
