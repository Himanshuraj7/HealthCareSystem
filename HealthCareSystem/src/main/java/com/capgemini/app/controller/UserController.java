package com.capgemini.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entity.Users;
import com.capgemini.app.exception.UserException;
import com.capgemini.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// register user function
	@PostMapping("/register")
	public String addUser(@Valid @RequestBody Users user, BindingResult br) throws UserException{
		System.out.println(user.toString());
		
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error : errors)
				err= err + error.getDefaultMessage() + " ";
			throw new UserException(err);
		}
		try {
			userService.addUser(user);
			return "User Added";
		}
		catch(Exception e) {
			throw new UserException("Please enter valid Password or Contact Number or Email Id");
		}
	}
	
	// login function using emilId and password
	@GetMapping("/login/{emailId}/{userPassword}")
	public String login(@PathVariable("emailId") String emailId, @PathVariable("userPassword") String userPassword) throws UserException{
		try {
			userService.login(emailId, userPassword);
			return "Login successful";
		}
		catch(Exception e) {
			throw new UserException(e.getMessage());
		}
	}
	
	// update user function using userName
	@PutMapping("/update/{userId}")
	public String updateUser(@PathVariable("userId") long userId, @RequestBody Users users) throws UserException{
	    	System.out.println(users.toString());
	   try {
		   String message = userService.updateUser(users, userId);
		   return message;
	   }
	   catch(Exception e) {
			throw new UserException(e.getMessage());
		}
	}
	
}
