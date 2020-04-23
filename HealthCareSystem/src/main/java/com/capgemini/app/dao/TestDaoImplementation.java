package com.capgemini.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.capgemini.app.entity.Test;

@Repository
public class TestDaoImplementation implements TestDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean addTest(Test test) {
		
		em.persist(test);
		return true;
	}

	@Override
	public boolean removeTest(long testId) {
		 Test test=em.find(Test.class, testId);
			if(test!=null)
				{
				em.remove(test);
				return true;
				}
			return false;
	}

	@Override
	public List<Test> getAllTest() {
		String Qstr="SELECT test FROM Test test";
		TypedQuery<Test> query=em.createQuery(Qstr,Test.class);
		return query.getResultList();
	}

	@Override
	public List<Test> getTest(long id) {
		String Qstr="SELECT test FROM Test test WHERE test.center="+id;
		TypedQuery<Test> query=em.createQuery(Qstr,Test.class);
		return query.getResultList();
	}

}
