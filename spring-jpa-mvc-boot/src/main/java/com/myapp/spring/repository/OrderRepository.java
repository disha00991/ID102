package com.myapp.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.hibernate.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@EntityGraph(value="order.customer.graph", type=EntityGraphType.LOAD)
	List<Order> findByOrderNumber(String orderNumber);
	
	//@Query(name="select o from Order as o JOIN FETCH o.customer")
	@EntityGraph(value="order.customer.graph", type=EntityGraphType.LOAD)
	List<Order> findAll();
	
	@EntityGraph(value="order.customer.graph", type=EntityGraphType.LOAD)
	Order findOne(Long arg0);
}
