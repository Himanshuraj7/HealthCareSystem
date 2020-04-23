package com.capgemini.app.dao;


import java.util.List;

import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Users;
import com.capgemini.exception.UserException;

public interface UserDao {
	
	boolean addUser(Users user);
	
	Users getMailId(String mailId) throws UserException;
	
	Users getPassword(String password) throws UserException;
}
