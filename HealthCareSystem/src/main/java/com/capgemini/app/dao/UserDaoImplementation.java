package com.capgemini.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Users;

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
	public List<Users> getAllUser() {
		String Qstr="SELECT user FROM User user";
		TypedQuery<Users> query=em.createQuery(Qstr, Users.class);
		return query.getResultList();	
	}

}
