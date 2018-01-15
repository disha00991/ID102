package com.hibernate.jpa.main;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import com.hibernate.jpa.dao.OrderRepositoryImplementation;
import com.hibernate.jpa.entity.Order;
import com.hibernate.jpa.util.HibernateJpaUtility;

public class TestOrder {

	public static void main(String[] args) {

		OrderRepositoryImplementation orderRepository = new OrderRepositoryImplementation();
		orderRepository.setEntityManager(HibernateJpaUtility.getFactory().createEntityManager());
		Order order1 = new Order("A1",new Date(),new Date(),"NEW");
		//orderRepository.save(order1);
		
		Order order = orderRepository.findById(9L);
		order.setLastUpdate(Date.from(Instant.now().plusSeconds(500000)));
		order.setStatus("PROCESSING");
		
		//orderRepository.delete(2L);
		//orderRepository.update(order);
		orderRepository.findAll().forEach(System.out::println);
		HibernateJpaUtility.closeEntryManagerFactory();
		
		
	}

}
