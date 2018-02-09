package com.metallica.trade.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${metallica.rabbitmq.exchange}")
	String exchange;

	public static final String NOTIFICATION_QUEUE="notification.queue";
	

	@Value("${metallica.rabbitmq.notificationRoutingkey}")
	private String notificationRoutingkey;

	
	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}
	
	
	@Bean
	Queue notificationQueue() {
		return new Queue(NOTIFICATION_QUEUE,false);
	}

	@Bean
	Binding notificationBinding() {
		return BindingBuilder.bind(notificationQueue()).to(exchange()).with(notificationRoutingkey);
	}
	

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
}
