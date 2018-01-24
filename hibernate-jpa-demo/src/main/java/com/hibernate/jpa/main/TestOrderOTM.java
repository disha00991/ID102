package com.hibernate.jpa.main;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.hibernate.jpa.dao.CustomerRepositoryImpl;
import com.hibernate.jpa.dao.OrderRepositoryImplementation;
import com.hibernate.jpa.entity.Customer;
import com.hibernate.jpa.entity.Order;
import com.hibernate.jpa.util.HibernateJpaUtility;

public class TestOrderOTM {

	public static void main(String[] args) {

		CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
		customerRepository.setEntityManager(HibernateJpaUtility.getFactory().createEntityManager());
		
		Customer customer1 = new Customer("Ridhi","Garg","ridhi@gmail.com");
		
		Order order1 = new Order("C123",new Date(),new Date(),"NEW");
		order1.addCustomerToOrder(customer1);
		Order order2 = new Order("D123",new Date(),new Date(),"NEW");
		order2.addCustomerToOrder(customer1);
		Order order3 = new Order("E123",new Date(),new Date(),"NEW");
		order3.addCustomerToOrder(customer1);
		
		customer1.getOrders().add(order1);
		customer1.getOrders().add(order2);
		customer1.getOrders().add(order3);
		
		customerRepository.save(customer1);
		HibernateJpaUtility.closeEntryManagerFactory();
		
		
	}

}
