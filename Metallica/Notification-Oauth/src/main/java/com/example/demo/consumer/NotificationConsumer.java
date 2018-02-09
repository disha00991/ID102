package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.CrudLog;
import com.example.demo.model.NotificationLog;
import com.example.demo.producer.Producer;

@Component
public class NotificationConsumer {

	@RabbitListener(queues = "${notification_queue}", containerFactory = "jsaFactory")
	public void recievedMessage(NotificationLog logs) {
		System.out.println("Recieved Message: " + logs);
	}
	

}
