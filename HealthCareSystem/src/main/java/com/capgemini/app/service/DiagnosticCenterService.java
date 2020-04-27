package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.dto.CenterDto;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;

public interface DiagnosticCenterService {
	
	boolean addCenter(CenterDto centerDto);
	
	boolean removeCenter(long id);
	
	List<DiagnosticCenter> getAllCenter();
	
	DiagnosticCenter getCenter(long centerId);
	
	List<Test> getAllTest();
	
	List<Test> getTest(long id);
	
	boolean addTest(long centerId,Test test);
	
	boolean removeTest(long testId);

}
