package com.example.demo.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.NotificationLog;
import com.example.demo.model.CrudLog;
import com.example.demo.model.User;
import com.example.demo.producer.Producer;
import com.mysql.jdbc.log.Log;

@Component
public class CrudConsumer {
	
	@Autowired
	Producer producer;
	
	@RabbitListener(queues = "${crud_queue}", containerFactory = "jsaFactory")
	public void recievedMessage(CrudLog logs) {
		callProduce();
		System.out.println("Recieved Message: " + logs);
	}

	public void callProduce() {
	String key = "sys.dev.info";
	String mssg = "trader found";
	producer.produce(new NotificationLog(mssg, key));
}
	
}
