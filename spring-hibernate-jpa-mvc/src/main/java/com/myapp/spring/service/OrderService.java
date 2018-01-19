package com.myapp.spring.service;

import com.myapp.spring.hibernate.model.Order;

import java.util.List;

public interface OrderService {
	List<Order> findAll();
	void save(Order order);
	Order findById(long id);
	List<Order> findByON(String orderNumber);
}
