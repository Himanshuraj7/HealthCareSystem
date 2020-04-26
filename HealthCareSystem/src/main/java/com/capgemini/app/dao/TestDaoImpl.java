package com.capgemini.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.app.dto.TestDto;
import com.capgemini.app.entities.Center;
import com.capgemini.app.entities.Test;

@Repository
public class TestDaoImpl implements TestDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean addCenter(TestDto testDto) {
		em.persist(testDto.getCenter());
		return true;
	}

	@Override
	public boolean removeCenter(long centerId) {
		Center center = em.find(Center.class, centerId);
		em.remove(center);
		return true;
	}

	public List<Center> getAllCenter() {
		String str = "SELECT center FROM Center center";
		TypedQuery<Center> query = em.createQuery(str, Center.class);
		return query.getResultList();
	}
	
	@Override
	public List<Center> getOnlyCenter() {
		String str = "SELECT center.centerId,center.centerName FROM Center center";
		Query query = em.createQuery(str, Center.class);
		return query.getResultList();
	}

	@Override
	public List<Center> getCenter(long centerid) {
		String str = "SELECT center FROM Center center WHERE center.centerId=" + centerid;
		TypedQuery<Center> query = em.createQuery(str, Center.class);
		return query.getResultList();
	}

	@Override
	public boolean addTest(long centerId, Test test) {
		Center center = em.find(Center.class, centerId);
		// test.setTestId(test.getTestId()); because testId is automatically generating
		test.setTestName(test.getTestName());
		center.getTest().add(test);
		em.persist(center);
		return true;
	}

	@Override
	public boolean removeTest(long testId) {
		Test test = em.find(Test.class, testId);
		em.remove(test);
		
		return true;
	}

	@Override
	public Center getCenter2(long centerId) {
		Center center = em.find(Center.class, centerId);
		return center;

	}

	

}
