package com.myapp.spring.publisher;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.config.RabbitMQConfig;

@RestController
public class RabbitMqSender {
	
	@Autowired
	private AmqpTemplate template;
	
	@GetMapping("sender/{msg}")
	public String sendMessage(@PathVariable("msg")String message) {
		Map<String, Object> objectMessage = new HashMap<>();
		objectMessage.put("message", message);
		template.convertAndSend(RabbitMQConfig.queueName, objectMessage);
		return "Message Sent to queue";
	}
}
