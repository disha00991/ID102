package com.myapp.spring.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.myapp.spring.subscribe.MessageSubscriber;




@Configuration
public class RabbitMQConfig {

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost("localhost");
		return connectionFactory;
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate() {
		return new RabbitTemplate(connectionFactory());
	}
	
	public final static String queueName ="spring-rabbitmq";
	
	@Bean
	@Autowired
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter adapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setConcurrentConsumers(4);
		container.setMessageListener(adapter);
		container.afterPropertiesSet();
		container.start();
		
		return container;
		
	}
	
	@Bean
	public MessageListenerAdapter adapter(MessageSubscriber subscriberInst) {
		return new MessageListenerAdapter(subscriberInst, "subscriber");
	}
	
}
