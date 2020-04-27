package com.capgemini.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.DiagnosticCenterDao;
import com.capgemini.app.dto.CenterDto;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.exception.InvalidException;
import com.capgemini.app.exception.NullException;
import com.capgemini.app.exception.WrongValueException;
/************************************************************************************
 *          @author          Ashish kumar
 *          
 *          Description      It is a Diagnostic center service class that provides the functionality 
 *          				 to find existing center,add tests in existing center,remove center 
                             
  *         Created Date    27-APR-2020
 ************************************************************************************/
@Service
@Transactional
public class DiagnosticCenterServiceImplementation implements DiagnosticCenterService{
	
	@Autowired
	private DiagnosticCenterDao centerDao;

	@Override
	public boolean addCenter(CenterDto center) {
		if(centerDao.addCenter(center))
			return true;
		else
			throw new InvalidException("center details are invalid");
	}

	@Override
	public boolean removeCenter(long id) {	
		DiagnosticCenter center=centerDao.getCenter(id);
		if(center!=null) {
		centerDao.removeCenter(center);
			return true;
		}
		else
			throw new WrongValueException("center doesn't exist");
	}

	@Override
	public List<DiagnosticCenter> getAllCenter() {
		if(centerDao.getAllCenter()!=null)
			return centerDao.getAllCenter();
		else
			throw new NullException("Ooops!!!There is no center");
	}

	@Override
	public DiagnosticCenter getCenter(long centerId) {
		if(centerDao.getCenter(centerId)!=null)
			return centerDao.getCenter(centerId);
		else 
			throw new NullException("Ooops!!!There is no center with this centerId");
	}

	@Override
	public List<Test> getTest(long centerId) {
		if(centerDao.getCenter(centerId)!=null)
			return centerDao.getTest(centerId);
		else 
			throw new NullException("Ooops!!!There is no test with this testId");
	}

	@Override
	public List<Test> getAllTest() {
		if(centerDao.getAllTest()!=null)
			return centerDao.getAllTest();
		else
			throw new NullException("Ooops!!!There is no test");
			
	}

	@Override
	public boolean addTest(long centerId,Test test) {
		if(centerDao.addTest(centerId,test))
		return true;
		else
			throw new NullException("center not present");
	}

	@Override
	public boolean removeTest(long testId) {
		if(centerDao.removeTest(testId))
			return true;
		else
			throw new NullException("Ooops!!!There is no test with this testId");
		
		
	}
	

}
