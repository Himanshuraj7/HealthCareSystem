package com.capgemini.app.dao;

import java.util.List;

import com.capgemini.app.entity.Test;

public interface TestDao {
	
	boolean addTest(Test test);
	
	boolean removeTest(long testId);
	
	List<Test> getAllTest();
	
	List<Test> getTest(long id);
	

}
