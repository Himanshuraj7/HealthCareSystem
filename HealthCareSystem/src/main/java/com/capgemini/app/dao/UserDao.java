package com.capgemini.app.dao;

import com.capgemini.app.entity.Users;

public interface UserDao {
	
	boolean addUser(Users user);
	
	boolean checkUserByEmail(String emailId);
	
	Users getUserByEmail(String emailId);

	boolean update(Users users, long userId);
}
