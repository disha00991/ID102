package com.myapp.spring;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.myapp.spring.aop.LoginManagerBean;
import com.myapp.spring.config.AppConfig;
import com.myapp.spring.dao.OrderDAO;
import com.myapp.spring.hibernate.model.Customer;
import com.myapp.spring.hibernate.model.Order;

public class TestSpringJpaHibernate {

	public static void main(String[] args) {
		AbstractApplicationContext springContainer = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		LoginManagerBean loginManagerBean = springContainer.getBean(LoginManagerBean.class);
		loginManagerBean.login("admin", "");
		
		
		OrderDAO orderDAO = springContainer.getBean(OrderDAO.class);
		orderDAO.findAll().forEach(System.out::println);
		
		Order order = new Order("D123", new Date(), new Date(), "NEW");
		order.setCustomer(new Customer("Disha", "xyz", "abc@gmail.com"));
		orderDAO.save(order);
		springContainer.close();
	}
}
