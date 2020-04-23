package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.entity.Test;

public interface TestService {
	
	boolean addTest(Test test);
	
	boolean removeTest(long testId);
	
	List<Test> getAllTest();
	
	List<Test> getTest(long id);

}
