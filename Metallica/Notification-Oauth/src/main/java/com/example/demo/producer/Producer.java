package com.example.demo.producer;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.model.NotificationLog;
import com.example.demo.model.CrudLog;
import com.example.demo.model.User;


@Component
public class Producer {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${exchange}")
	private String exchange;
	
	
	public void produce2(CrudLog logs){
		String routingKey = logs.getRoutingKey();
		amqpTemplate.convertAndSend(exchange, routingKey, logs);
		System.out.println("Send msg = " + logs);
	}

	
	public void produce(NotificationLog logs){
		String routingKey = logs.getRoutingKey();
		amqpTemplate.convertAndSend(exchange, routingKey, logs);
		System.out.println("Send msg = " + logs);
	}
	



}
