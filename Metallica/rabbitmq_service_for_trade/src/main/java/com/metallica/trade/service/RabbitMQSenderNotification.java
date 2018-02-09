package com.metallica.trade.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSenderNotification {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${metallica.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${metallica.rabbitmq.notificationRoutingkey}")
	private String routingkey;	
		
	public void send(String message) {
		amqpTemplate.convertAndSend(exchange, routingkey, message);
		System.out.println("Send notification msg = " + message);
	    
	}
	
}