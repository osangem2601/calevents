package com.adp.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adp.db.model.User;
import com.adp.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping(method =RequestMethod.GET)
    public ResponseEntity<List<User>>  getUserList()
    {
    	logger.info("Get user list request");
    	List<User> userList =  userService.getUsers();    
    	if(userList== null) {    		
    		return ResponseEntity.notFound().build();    		
    	}
    	else {
    		return ResponseEntity.status(HttpStatus.FOUND).body(userList);	
    	}
    }
	
    
    @RequestMapping(value="/{id}", method =RequestMethod.GET)
    public ResponseEntity<User>  getUser(@PathVariable Long id)
    {
    	logger.info("Get user request");
    	User u =  userService.getUser(id);    
    	if(u == null) {    		
    		return ResponseEntity.notFound().build();    		
    	}
    	else {
    		return ResponseEntity.status(HttpStatus.FOUND).body(u);	
    	}
    }
	
    
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<HttpStatus> creatUser(@RequestBody User user)
    {
    	logger.info("Create user request");
    	logger.info("Username :" + user.getUserName());
    	logger.info("Email : "+ user.getEmail());
    	userService.createUser(user);
    	logger.info("User created");
    	
    	return ResponseEntity.status(HttpStatus.CREATED).build();
   
    }
    
    
    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user)
    {
    	logger.info("Update user request");
    	logger.info("Username :" + user.getUserName());
    	logger.info("Email : "+ user.getEmail());
    	userService.updateUser(user);
    	logger.info("User updated");
    	
    	return ResponseEntity.status(HttpStatus.OK).build();
   
    }
    
}
