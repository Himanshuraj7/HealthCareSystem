package com.capgemini.app.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.UserDao;
import com.capgemini.app.entity.Users;
import com.capgemini.app.exception.UserException;

@Transactional
@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	// register function
	@Override
	public boolean addUser(Users user) {
		return userDao.addUser(user);
	}
	
	// login function
	@Override
	public long login(String emailId, String userPassword) throws UserException{   
    	if(userDao.checkUserByEmail(emailId)==false)
    		throw new UserException("The entered User does not exist, Please enter a valid email");
    	Users user=userDao.getUserByEmail(emailId);

    	if(user.getUserPassword().equals(userPassword)==false)
    		throw new UserException("The email and password Combination does not match");

    	return user.getUserId();
    }

	// update function
	@Override
	public String updateUser(Users users, long userId) throws UserException{
		if(userDao.update(users, userId)==false)
			throw new UserException("No details exist for given User");
		return "user details updated";	
	}

}
