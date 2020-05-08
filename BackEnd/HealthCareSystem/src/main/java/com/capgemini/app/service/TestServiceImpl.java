package com.capgemini.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.TestDao;
import com.capgemini.app.dto.TestDto;
import com.capgemini.app.entities.DiagnosticCenter;
import com.capgemini.app.entities.Test;
import com.capgemini.app.exceptions.TestException;

/************************************************************************************
 * 			@author 			Vishal Mawani
 * 
 *         Description   		Test Service class provides functionality to add a test,
 *         						remove a test, view diagnostic centers and throws corresponding
 *         						exceptions.
 * 
 *         Created Date 		27-APR-2020
 ************************************************************************************/
@Service
@Transactional
public class TestServiceImpl implements TestService {

	@Autowired
	TestDao testDao;

	@Override
	public boolean addCenter(TestDto testDto) throws TestException {
		if (testDao.addCenter(testDto))
			return true;
		else
			throw new TestException("Center not added.");
	}

	@Override
	public String addTest(long centerId, Test test) throws TestException {
		if (testDao.addTest(centerId, test))
			return "Test Added Successfully";
		else
			throw new TestException("Test already exists");
	}

	@Override
	public String removeTest(long testId) throws TestException {
		if (testDao.removeTest(testId))
			return "Test Removed";
		else
			throw new TestException("Test not found.");

	}

	@Override
	public List<DiagnosticCenter> getAllCenter() throws TestException {
		if(testDao.getAllCenter()!=null)
			return testDao.getAllCenter();
		else
			throw new TestException("Diagnostic Centers not present. ");
	}

	@Override
	public DiagnosticCenter getCenter(long centerId) throws TestException {
		if(testDao.getCenter(centerId)!=null) {
			return testDao.getCenter(centerId);
		}
		else {
			throw new TestException("Diagnostic Center not found.");
		}
	}

}
