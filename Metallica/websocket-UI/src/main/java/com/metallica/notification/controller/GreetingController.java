package com.metallica.notification.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.metallica.trade.models.Market;

//import com.metallica.trade.models.Market;

//import com.metallica.trade.models.Market;

@Controller
@EnableScheduling
public class GreetingController {

	@Autowired
	private SimpMessagingTemplate simpleTemplate;

	private Logger logger = LoggerFactory.getLogger(GreetingController.class);

	public void sendMarketData(List<Market> markets) throws Exception {
		// logger.debug("***********************" + markets);
		try {
			this.simpleTemplate.convertAndSend("/topic/ticker", markets);
		} catch (Exception e) {
			logger.error("Error in sending Messages");
		}
	}

	public void sendTradeData(String message) throws Exception {
		// logger.debug("***********************" + message);
		try {
			this.simpleTemplate.convertAndSend("/topic/notify", message);
		} catch (Exception e) {
			logger.error("Error in sending Messages");
		}
	}
}
