package com.capgemini.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.app.dto.TestDto;
import com.capgemini.app.entities.DiagnosticCenter;
import com.capgemini.app.entities.Test;
/************************************************************************************
 *          @author          Vishal Mawani
 *          
 *          Description      Test Dao class provides functionality to persist new test,
 *          				 remove a test and find centers.
                             
  *         Created Date     27-APR-2020
 ************************************************************************************/

@Repository
public class TestDaoImpl implements TestDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean addCenter(TestDto testDto) {
		em.persist(testDto.getCenter());
		return true;
	}

	public List<DiagnosticCenter> getAllCenter() {
		String str = "SELECT diagnosticCenter FROM DiagnosticCenter diagnosticCenter";
		TypedQuery<DiagnosticCenter> query = em.createQuery(str, DiagnosticCenter.class);
		return query.getResultList();
	}

	@Override
	public DiagnosticCenter getCenter(long centerid) {
		String str = "SELECT diagnosticCenter FROM DiagnosticCenter diagnosticCenter WHERE diagnosticCenter.centerId="
				+ centerid;
		TypedQuery<DiagnosticCenter> query = em.createQuery(str, DiagnosticCenter.class);
		return query.getSingleResult();
	}

	@Override
	public boolean addTest(long centerId, Test test) {
		DiagnosticCenter diagnosticCenter = em.find(DiagnosticCenter.class, centerId);
		String testName = test.getTestName();
		List<Test> testList = diagnosticCenter.getTest();

		for (Test t : testList) {
			if (t.getTestName().equalsIgnoreCase(testName)) {
				return false;
			}
		}
		test.setTestName(testName);
		diagnosticCenter.getTest().add(test);
		em.persist(diagnosticCenter);
		return true;

	}

	@Override
	public boolean removeTest(long testId) {
		Test test = em.find(Test.class, testId);
		if (test != null) {
			em.remove(test);
			return true;
		} else {
			return false;
		}
	}

}
