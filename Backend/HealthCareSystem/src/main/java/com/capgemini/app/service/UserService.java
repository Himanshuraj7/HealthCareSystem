package com.capgemini.app.service;

import com.capgemini.app.entity.Users;
import com.capgemini.app.exception.UserException;

public interface UserService {
	
	boolean addUser(Users user) throws UserException;
	
	String login(String emailId, String userPassword) throws UserException;

	String updateUser(Users users, long userId, String emailId) throws UserException;

	boolean checkEmailExist(String email) throws UserException;

	String forgotPassword(Users users, long userId, String emailId) throws UserException;
}
