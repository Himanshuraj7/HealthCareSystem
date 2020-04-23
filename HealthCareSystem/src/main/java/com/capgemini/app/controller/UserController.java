package com.capgemini.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entity.Users;
import com.capgemini.app.service.UserService;
import com.capgemini.exception.UserException;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/addUser")
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
			userservice.addUser(user);
			return "User Added";
		}
		catch(Exception e) {
			throw new UserException("Please enter valid Password or Contact Number or Email Id");
		}
		
	}
	
//	@GetMapping("/getMailId")
//    public ResponseEntity<List<Users>> getAllUser() {
//		List<Users> list = userservice.getAllUser();
//		return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
//	}
	
}
