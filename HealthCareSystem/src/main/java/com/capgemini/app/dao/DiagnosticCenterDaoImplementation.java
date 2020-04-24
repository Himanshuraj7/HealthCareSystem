package com.capgemini.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;

@Repository

public class DiagnosticCenterDaoImplementation implements DiagnosticCenterDao{
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public boolean addCenter(DiagnosticCenter center) {
		em.persist(center);
		return true;
	}

	@Override
	public boolean removeCenter(long id) {
		DiagnosticCenter center = em.find(DiagnosticCenter.class, id);
		if(center!=null)
			{
			em.remove(center);
			return true;
			}
		return false;
	}

	@Override
	public List<DiagnosticCenter> getAllCenter() {
		String Qstr="SELECT center FROM DiagnosticCenter center";
		TypedQuery<DiagnosticCenter> query=em.createQuery(Qstr,DiagnosticCenter.class);
		return query.getResultList();	
	}

	@Override
	public DiagnosticCenter getCenter(long centerId) {
		
		DiagnosticCenter center=em.find(DiagnosticCenter.class,centerId);
		return center;
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
