package com.capgemini.app.dao;


import java.util.List;

import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;


public interface DiagnosticCenterDao {
	
	boolean addCenter(DiagnosticCenter center);
	
	boolean removeCenter(long id);
	
	List<DiagnosticCenter> getAllCenter();
	
	DiagnosticCenter getCenter(long centerId);
	
	List<Test> getAllTest();
	
	List<Test> getTest(long id);
	
}
