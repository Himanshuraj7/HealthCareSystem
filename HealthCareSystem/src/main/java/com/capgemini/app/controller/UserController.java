package com.capgemini.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entity.Users;
import com.capgemini.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/addUser")
	public ResponseEntity<Users> addUser(@RequestBody Users user) {
		System.out.println(user.toString());
		userservice.addUser(user);
		
		return new ResponseEntity<Users>(HttpStatus.OK);
	}
	
	@GetMapping("/getAllUser")
    public ResponseEntity<List<Users>> getAllUser() {
		List<Users> list = userservice.getAllUser();
		return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
	}
	
	

}
