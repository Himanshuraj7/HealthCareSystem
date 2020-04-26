package com.capgemini.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entity.Users;
import com.capgemini.app.exception.UserException;
import com.capgemini.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
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
	
	@GetMapping("/login/{emailId}/{userPassword}")
	public ResponseEntity<Long> login(@PathVariable("emailId") String emailId, @PathVariable("userPassword") String userPassword) throws UserException{
		try {
			long userId=userService.login(emailId, userPassword);
			return new ResponseEntity<Long>(userId, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new UserException(e.getMessage());
		}
	}
}
