package com.capgemini.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.DiagnosticCenterDao;
import com.capgemini.app.entity.DiagnosticCenter;

@Service
public class DiagnosticCenterServiceImplementation implements DiagnosticCenterService{
	
	@Autowired
	private DiagnosticCenterDao centerDao;

	@Override
	public boolean addCenter(DiagnosticCenter center) {
		
		return centerDao.addCenter(center);
	}

	@Override
	public boolean removeCenter(long id) {
		
		return centerDao.removeCenter(id);
	}

	@Override
	public List<DiagnosticCenter> getAllCenter() {
		
		return centerDao.getAllCenter();
	}
	

}
