package com.myapp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myapp.spring.model.User;
import com.myapp.spring.repository.UserRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
    private UserRepository ur;


    @PostMapping(value = "/users/save", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        ur.save(user);
        return new ResponseEntity<User>(user, OK);
    }
    @GetMapping(value = "/users/all", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<List<User>> allUser() {
        return new ResponseEntity<List<User>>(ur.findAll(), OK);
    }
    
    @PutMapping(value="/users/edit", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<List<User>> editUser(@RequestBody User user) {
    	ur.save(user);
        return new ResponseEntity<List<User>>(ur.findAll(), OK);
    }
    
    @DeleteMapping(value="/users/delete/{userId}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<List<User>> deleteUser(@PathVariable("userId") long userId) {
    	ur.delete(userId);
        return new ResponseEntity<List<User>>(ur.findAll(), OK);
    }
}
