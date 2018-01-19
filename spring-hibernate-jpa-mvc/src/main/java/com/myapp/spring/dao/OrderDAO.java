package com.myapp.spring.dao;

import com.myapp.spring.hibernate.model.Order;
import java.util.List;

public interface OrderDAO {
	
	public List<Order> findAll();
	void save(Order order);
	public Order findById(long id);
	public List<Order> findByON(String orderNumber);

}
