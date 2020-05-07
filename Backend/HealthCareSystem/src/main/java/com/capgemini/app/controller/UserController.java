package com.capgemini.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entity.Users;
import com.capgemini.app.exception.UserException;
import com.capgemini.app.service.UserService;

/************************************************************************************
 *          @author          Himanshu Raj
 *          
 *          Description      It is a User controller class that provides the functionality 
 *          				 to customer to interact with our product and return the requests to frontend
                             
  *         Created Date    27-APR-2020
 ************************************************************************************/

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/************************************************************************************
	 * Method                : addUser
     * Description           : to sign up customer
	 * @param user           : Users entity
	 * @returns String       : return message if sign up successful else throw exception
	 * @throws UserException : It is thrown if form validation fails
	 ************************************************************************************/
	@PostMapping("/register")
	public String addUser(@RequestBody Users user) throws UserException {
		try {
			userService.addUser(user);
			return "User Added, Please proceed to Login";
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
	}

	/************************************************************************************
	 * Method                : login
     * Description           : to login customer and admin
	 * @param emailId        : email id
	 * @param userPassword   : user password
	 * @returns String       : return message if login successful else throw exception
	 * @throws UserException : It is thrown if login is unsuccessful
	 ************************************************************************************/
	@PostMapping("/login/{emailId}/{userPassword}")
	public String login(@PathVariable("emailId") String emailId, @PathVariable("userPassword") String userPassword)
			throws UserException {
		try {
			String message = userService.login(emailId, userPassword);
			return message;
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
	}

	/************************************************************************************
	 * Method                : updateUser
     * Description           : to update customer data after login 
	 * @param userId         : user id
	 * @param users          : Users entity
	 * @returns String       : return message if update successful else throw exception
	 * @throws UserException : It is thrown if update is unsuccessful
	 ************************************************************************************/
	@PutMapping("/update/{userId}/{emailId}")
	public String updateUser(@PathVariable("userId") long userId, @PathVariable("emailId") String emailId, 
			@RequestBody Users users) throws UserException {
		try {
			String message = userService.updateUser(users, userId, emailId);
			return message;
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
	}
	
	/************************************************************************************
	 * Method                : forgotPassword
     * Description           : to reset password if user forgets it 
	 * @param userId         : user id
	 * @param emailId        : email id
	 * @param users          : Users entity
	 * @returns String       : return message if password is successfully updated else throw exception
	 * @throws UserException : It is thrown if update is unsuccessful
	 ************************************************************************************/
		@PutMapping("/forgotPassword/{userId}/{emailId}")
		public String forgotPassword(@PathVariable("userId") long userId, @PathVariable("emailId") String emailId, 
				@RequestBody Users users) throws UserException {
			try {
				String message = userService.forgotPassword(users, userId, emailId);
				return message;
			} catch (Exception e) {
				throw new UserException(e.getMessage());
			}
		}
}
