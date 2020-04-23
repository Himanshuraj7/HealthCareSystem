package com.capgemini.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.capgemini.app.entity.Users;
import com.capgemini.app.exception.UserException;

@Repository
public class UserDaoImplementation implements UserDao{
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public boolean addUser(Users user) {
		em.persist(user);
		return true;
	}

	@Override
	public Users getMailId(String mailId) throws UserException {
		Users users=em.find(Users.class, mailId);
		if(users==null) throw new UserException("User not registered");
		return users;
	}

	@Override
	public Users getPassword(String password) throws UserException {
		Users users=em.find(Users.class, password);
		if(users==null) throw new UserException("User Id or Password is invalid");
		return users;
	}
	
	

}
