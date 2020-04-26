package com.capgemini.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.TestDao;
import com.capgemini.app.dto.TestDto;
import com.capgemini.app.entities.Center;
import com.capgemini.app.entities.Test;

@Service
@Transactional
public class TestServiceImpl implements TestService {

	@Autowired
	TestDao testDao;

	@Override
	public boolean addCenter(TestDto testDto) {

		return testDao.addCenter(testDto);
	}

	@Override
	public List<Center> getAllCenter() {
		return testDao.getAllCenter();
	}

	@Override
	public List<Center> getCenter(long centerId) {
		return testDao.getCenter(centerId);
	}

	@Override
	public boolean addTest(long centerId, Test test) {
		return testDao.addTest(centerId, test);
	}

	@Override
	public Center getCenter2(long centerId) {
		return testDao.getCenter2(centerId);
	}

	@Override
	public boolean removeTest(long centerId, Test test) {
		return testDao.removeTest(centerId, test);

	}

}
