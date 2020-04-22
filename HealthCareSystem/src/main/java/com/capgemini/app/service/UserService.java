package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Users;

public interface UserService {
	
	boolean addUser(Users user);
	
	List<Users> getAllUser();

}
