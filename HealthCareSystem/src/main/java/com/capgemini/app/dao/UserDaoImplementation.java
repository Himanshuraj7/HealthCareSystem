package com.capgemini.app.dao;

import com.capgemini.app.entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplementation implements UserDao{
	
	@PersistenceContext
	private EntityManager em;
	
	
	// register function
	@Override
	public boolean addUser(Users user) {
		em.persist(user);
		return true;
	}
	
	// login function, checking whether account exist or not
	@Override
	public boolean checkUserByEmail(String emailId){
   		String Qstr="SELECT users.emailId FROM Users users WHERE users.emailId= :emailId";
   		TypedQuery<String> query=em.createQuery(Qstr, String.class).setParameter("emailId",emailId);
   		try{
   			query.getSingleResult();
   		}
   		catch(Exception ex){
   			return false;
   		}
   		return true;
   	}
	
	// login function, getting email id for matching with password entered
	@Override
	public Users getUserByEmail(String emailId){
		String Qstr="SELECT users FROM Users users WHERE users.emailId= :emailId";
   		TypedQuery<Users> query=em.createQuery(Qstr, Users.class).setParameter("emailId",emailId);
   		return query.getSingleResult();
	}
	
	// update function
	@Override
	public boolean update(Users users, long userId) {
		  Users userUpdate= em.find(Users.class, userId);
		  if(userUpdate==null) return false;
		  
		  userUpdate.setUserPassword(users.getUserPassword());
		  userUpdate.setContactNo(users.getContactNo());
		  userUpdate.setEmailId(users.getEmailId());
		 
		  em.persist(userUpdate);
		  
		  return true;
		
	}
	
}