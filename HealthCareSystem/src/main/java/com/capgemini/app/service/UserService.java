package com.capgemini.app.service;

import com.capgemini.app.entity.Users;
import com.capgemini.app.exception.UserException;

public interface UserService {
	
	boolean addUser(Users user) throws UserException;
	
	long login(String emailId, String userPassword) throws UserException;

	String updateUser(Users users, long userId) throws UserException;

	boolean checkEmailExist(String email) throws UserException;
}
