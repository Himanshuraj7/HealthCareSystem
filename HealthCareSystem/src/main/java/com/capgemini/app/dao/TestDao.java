package com.capgemini.app.dao;

import java.util.List;

import com.capgemini.app.entities.Test;

public interface TestDao {

	boolean addTest(Test test);
	boolean removeTest(long testId);
	List<Test> getAllTests();
	Test getTest(long testId);
	
	
}