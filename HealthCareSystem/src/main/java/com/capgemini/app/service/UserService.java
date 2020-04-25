package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Users;
import com.capgemini.app.exception.UserException;

public interface UserService {
	
	boolean addUser(Users user);
	
	boolean login(String mailId, String password) throws UserException;
	
	//Users getPassword(String password) throws UserException;

}
