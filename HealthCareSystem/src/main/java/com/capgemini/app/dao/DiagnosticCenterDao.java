package com.capgemini.app.dao;


import java.util.List;

import com.capgemini.app.entity.DiagnosticCenter;

public interface DiagnosticCenterDao {
	
	boolean addCenter(DiagnosticCenter center);
	
	boolean removeCenter(long id);
	
	List<DiagnosticCenter> getAllCenter();
	
}
