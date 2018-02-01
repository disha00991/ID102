package com.myapp.spring.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@RequestMapping(value="/product", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllFlights() {
		return new ResponseEntity<List<Product>>(productRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/product/save", produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<String> placeAFlight(@RequestBody Product product) {
		productRepository.save(product);
		return new ResponseEntity<String>("A product detail has been created!", HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/product/update", produces = APPLICATION_JSON_VALUE, method=RequestMethod.PUT)
	public ResponseEntity<String> updateAFlight(@RequestBody Product product) {
		productRepository.save(product);
		return new ResponseEntity<String>("Product detail has been updated!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/product", produces = APPLICATION_JSON_VALUE, method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAFlight(@RequestParam("productId") long productId) {
		productRepository.delete(productId);
		return new ResponseEntity<String>("Product detail deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/product/find", method=RequestMethod.GET)
	public ResponseEntity<Product> findByProductName(@RequestParam("productName")String productName) {
		return new ResponseEntity<Product>(productRepository.findByProductName(productName), HttpStatus.OK);
	}
}
