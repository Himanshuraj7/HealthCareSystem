package com.capgemini.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

	public List<Center> getAllCenter() {
		String str = "SELECT center FROM Center center";
		TypedQuery<Center> query = em.createQuery(str, Center.class);
		return query.getResultList();
	}

	@Override
	public List<Center> getCenter(long centerid) {
		String Qstr = "SELECT center FROM Center center WHERE center.centerId=" + centerid;
		TypedQuery<Center> query = em.createQuery(Qstr, Center.class);
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
	public boolean removeTest(long centerId, Test test) {
		Center center = em.find(Center.class, centerId);
		
		//(center.getTest().contains(test);
			center.getTest().remove(test);
			em.persist(center);
		return true;
	}
	
	@Override
	public Center getCenter2(long centerId) {
		Center center = em.find(Center.class, centerId);
		return center;

	}
	
	

}
