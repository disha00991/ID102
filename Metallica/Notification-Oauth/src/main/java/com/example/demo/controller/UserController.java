package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.NotificationLog;
import com.example.demo.model.CrudLog;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.producer.Producer;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	Producer producer;

	@Autowired
	private UserRepository repository;

	@GetMapping(value = "/")
	public String index() {
		return "Hello world";
	}

	@GetMapping(value = "/trade")
	public String privateArea() {
		return "Private area";
	}

	@PostMapping(value = "/save")
	public ResponseEntity<String> sp() {
		List<Role> roles = new ArrayList<>();
		Role role1 = new Role("admin");
		roles.add(role1);
		User user1 = new User("trader2", "trader2", roles);
		repository.save(user1);
		return new ResponseEntity<String>("hello", HttpStatus.OK);
	}


	@GetMapping("/trade/find/{id}")
	public String sendMsg(@PathVariable("id") int id) {

		User user = repository.findOne(id);
		String key2 = "prod.dev.info";
		producer.produce2(new CrudLog(user, key2));
		return "Done";
	}



}
