package com.myapp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.hibernate.model.Order;
import com.myapp.spring.repository.OrderRepository;

@RestController // no need to take care of view resolver. Only JSON data is returned using
				// "REST" .this converts object to json and back
public class OrderController {

	@Autowired
	private OrderRepository orderService;

	// encapsulating the response into an object
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getAllOrders() {
		return new ResponseEntity<List<Order>>(orderService.findAll(), HttpStatus.OK);
	}

	// http://localhost:8081/spring-mvc/orders
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public ResponseEntity<String> placeAnOrder(@RequestBody Order order) {// convert the json data and deserialize into
																			// the object "Order"
		orderService.save(order);
		return new ResponseEntity<String>("Order Saved", HttpStatus.CREATED);
	}

	// http://localhost:8081/spring-mvc/orders/1
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> findAnOrderById(@PathVariable("id") long id) {// convert the json data and deserialize
																				// into the object "Order"
		return new ResponseEntity<Order>(orderService.findOne(id), HttpStatus.OK);
	}

	// http://localhost:8081/spring-mvc/orders
	@RequestMapping(value = "/orders", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAnOrder(@RequestBody Order order) {
		orderService.save(order);
		return new ResponseEntity<String>("Order updated", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteOrder(@PathVariable("id") long id) {
		orderService.delete(id);
		return new ResponseEntity<String>("Order deleted", HttpStatus.OK);
	}

	// implemented in orderRepository
	// http://localhost:8081/spring-mvc/orders/find?orderNumber=
	@RequestMapping(value = "/orders/find", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findByOrderNumber(@RequestParam("orderNumber") String orderNumber) {
		return new ResponseEntity<List<Order>>(orderService.findByOrderNumber(orderNumber), HttpStatus.OK);
	}

}
