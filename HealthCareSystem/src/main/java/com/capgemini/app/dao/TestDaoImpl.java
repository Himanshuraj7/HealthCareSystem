package com.capgemini.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.app.entities.Test;

@Repository
public class TestDaoImpl implements TestDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean addTest(Test test) {
		em.persist(test);
		return false;
	}

	@Override
	public boolean removeTest(long testId) {
		Test test = em.find(Test.class, testId);
		if(test!=null)
		{
			em.remove(test);
			return true;
		}
		return false;
	}

	@Override
	public List<Test> getAllTests() {
		TypedQuery<Test> query = em.createQuery("from TEST", Test.class);
		return query.getResultList();
	}

	@Override
	public Test getTest(long testId) {
		Test test = em.find(Test.class, testId);
		return test;
	}

}
