package com.capgemini.app.dao;


import java.util.List;

import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Users;

public interface UserDao {
	
	boolean addUser(Users user);
	
	List<Users> getAllUser();
	
}
