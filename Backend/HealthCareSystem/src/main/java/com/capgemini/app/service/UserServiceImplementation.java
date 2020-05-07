package com.capgemini.app.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.UserDao;
import com.capgemini.app.entity.Users;
import com.capgemini.app.exception.UserException;

/************************************************************************************
 *          @author          Himanshu Raj
 *          
 *          Description      It is a User service class that provides the functionality 
 *          				 to add new user, login and update user details 
                             
  *         Created Date    27-APR-2020
 ************************************************************************************/

@Transactional
@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	// register function
	@Override
	public boolean addUser(Users user) throws UserException {
		checkEmailExist(user.getEmailId());
		return userDao.addUser(user);
	}
	
	 public boolean checkEmailExist(String email) throws UserException {
		 if(userDao.checkUserByEmail(email)==true)
			 throw new UserException("User already exists, please login with your email");
		else return true;
	}
	
	// login function, validating email id and password
	@Override
	public String login(String emailId, String userPassword) throws UserException{   
    	if(userDao.checkUserByEmail(emailId)==false)
    		throw new UserException("The entered User does not exist, Please enter a valid email");
    	Users user=userDao.getUserByEmail(emailId);

    	if(user.getUserPassword().equals(userPassword)==false)
    		throw new UserException("The email and password does not match");

    	return "login successful";
    }

	// update function
	@Override
	public String updateUser(Users users, long userId, String emailId) throws UserException{
		if(userDao.update(users, userId, emailId)==false)
			throw new UserException("No details exist for given User");
		return "user details updated";	
	}
	
	// forgot password function
	@Override
	public String forgotPassword(Users users, long userId, String emailId) throws UserException{	
		if(userDao.forgotPassword(users, userId, emailId)==false)
			throw new UserException("User not registered");
		return "Password updated successfully";	
	}

}
