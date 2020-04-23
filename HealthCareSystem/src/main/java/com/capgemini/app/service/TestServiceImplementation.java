package com.capgemini.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.TestDao;
import com.capgemini.app.entity.Test;

@Service
@Transactional
public class TestServiceImplementation implements TestService{
	@Autowired
	TestDao testDao;

	@Override
	public boolean addTest(Test test) {
		
		return testDao.addTest(test);
		
	}

	@Override
	public boolean removeTest(long testId) {
		return testDao.removeTest(testId);
	}

	@Override
	public List<Test> getAllTest() {
		
		return testDao.getAllTest();
		
	}

	@Override
	public List<Test> getTest(long id) {
		
		return testDao.getTest(id);
	}

}
