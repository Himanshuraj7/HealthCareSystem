package com.capgemini.app.dao;


import java.util.List;

import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;


public interface DiagnosticCenterDao {
	
	
	boolean addCenter(DiagnosticCenter center);
	
	boolean removeCenter(DiagnosticCenter center);
	
	List<DiagnosticCenter> getAllCenter();
	
	DiagnosticCenter getCenter(long centerId);
	
	List<Test> getAllTest();
	
	List<Test> getTest(long id);
	
	boolean addTest(long centerId,Test test);
	
	boolean removeTest(long testId);
	
	boolean updateCenter(DiagnosticCenter center,long centerId);
	
}
