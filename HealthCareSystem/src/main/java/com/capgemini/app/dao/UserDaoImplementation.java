package com.capgemini.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	public boolean checkUserByEmail(String emailId){
   		String Qstr="SELECT users.emailId FROM Users users WHERE users.emailId= :emailId";
   		TypedQuery<String> query=em.createQuery(Qstr,String.class).setParameter("emailId",emailId);
   		try{
   			query.getSingleResult();
   		}
   		catch(Exception ex){
   			return false;
   		}
   		return true;
   	}
	
	public Users getUserByEmail(String emailId){
		String Qstr="SELECT users FROM Users users WHERE users.emailId= :emailId";
   		TypedQuery<Users> query=em.createQuery(Qstr,Users.class).setParameter("emailId",emailId);
   		return query.getSingleResult();
	}
	
}