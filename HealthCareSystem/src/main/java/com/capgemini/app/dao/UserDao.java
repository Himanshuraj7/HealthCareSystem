package com.capgemini.app.dao;

import java.util.List;

import com.capgemini.app.entity.Users;
import com.capgemini.app.exception.UserException;

public interface UserDao {
	
	boolean addUser(Users user);
	
	boolean checkUserByEmail(String emailId);
	Users getUserByEmail(String emailId);
}
