package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.entity.DiagnosticCenter;

public interface DiagnosticCenterService {
	
	boolean addCenter(DiagnosticCenter center);
	
	boolean removeCenter(long id);
	
	List<DiagnosticCenter> getAllCenter();

}
