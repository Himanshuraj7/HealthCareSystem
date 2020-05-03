package com.capgemini.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
/************************************************************************************
 *          @author          Ashish kumar
 *          
 *          Description      It is a Diagnostic center dao class that provides the functionality 
 *          				 to persist new center,persist any changes made in the given functionality 
                             
  *         Created Date    27-APR-2020
 ************************************************************************************/

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
	public boolean removeCenter(DiagnosticCenter center) {
			em.remove(center);
			return true;
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
		String Qstr="SELECT test FROM Test test WHERE test.centerId="+id;
		TypedQuery<Test> query=em.createQuery(Qstr,Test.class);
		return query.getResultList();
	}

	@Override
	public boolean addTest(long centerId,Test test) {
		DiagnosticCenter center = em.find(DiagnosticCenter.class, centerId);
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
	public boolean updateCenter(DiagnosticCenter center,long centerId) {
		DiagnosticCenter updateCenter=em.find(DiagnosticCenter.class,centerId);
		if(updateCenter==null)
			return false;
		updateCenter.setCenterName(center.getCenterName());
		updateCenter.setAddress(center.getAddress());
		updateCenter.setContactNo(center.getContactNo());
		em.merge(updateCenter);
		return true;
	}

	


}
