package com.capgemini.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.app.dto.TestDto;
import com.capgemini.app.entities.DiagnosticCenter;
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
		DiagnosticCenter diagnosticCenter = em.find(DiagnosticCenter.class, centerId);
		em.remove(diagnosticCenter);
		return true;
	}

	public List<DiagnosticCenter> getAllCenter() {
		String str = "SELECT diagnosticCenter FROM DiagnosticCenter diagnosticCenter";
		TypedQuery<DiagnosticCenter> query = em.createQuery(str, DiagnosticCenter.class);
		return query.getResultList();
	}
	
	@Override
	public List<DiagnosticCenter> getOnlyCenter() {
		String str = "SELECT center.centerId,center.centerName FROM Center center";
		Query query = em.createQuery(str, DiagnosticCenter.class);
		return query.getResultList();
	}

	@Override
	public List<DiagnosticCenter> getCenter(long centerid) {
		String str = "SELECT diagnosticCenter FROM DiagnosticCenter diagnosticCenter WHERE diagnosticCenter.centerId=" + centerid;
		TypedQuery<DiagnosticCenter> query = em.createQuery(str, DiagnosticCenter.class);
		return query.getResultList();
	}

	@Override
	public boolean addTest(long centerId, Test test) {
		DiagnosticCenter diagnosticCenter = em.find(DiagnosticCenter.class, centerId);
		// test.setTestId(test.getTestId()); because testId is automatically generating
		test.setTestName(test.getTestName());
		diagnosticCenter.getTest().add(test);
		em.persist(diagnosticCenter);
		return true;
	}

	@Override
	public boolean removeTest(long testId) {
		Test test = em.find(Test.class, testId);
		em.remove(test);
		
		return true;
	}

	@Override
	public DiagnosticCenter getCenter2(long centerId) {
		DiagnosticCenter diagnosticCenter = em.find(DiagnosticCenter.class, centerId);
		return diagnosticCenter;

	}

	

}
