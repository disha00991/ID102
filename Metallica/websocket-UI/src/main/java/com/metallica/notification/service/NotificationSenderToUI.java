package com.metallica.notification.service;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metallica.notification.controller.GreetingController;
//import com.metallica.trade.models.Market;
//import com.metallica.trade.models.Market;
import com.metallica.trade.models.Market;

@Component
public class NotificationSenderToUI {

	@Autowired
	private GreetingController controller;

	@RabbitListener(queues = "${queue}")
	public void recievedMessage(List<Market> markets) throws Exception {
		System.out.println("Recieved Message: " + markets);
		controller.sendMarketData(markets);
	}
	
	@RabbitListener(queues = "${metallica.rabbitmq.notificationQueue}")
	public void recievedTradeMessage(String message) throws Exception {
		System.out.println("Recieved Message: " + message);
		controller.sendTradeData(message);
	}
}
