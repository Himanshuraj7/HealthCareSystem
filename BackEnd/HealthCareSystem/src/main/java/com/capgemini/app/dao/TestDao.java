package com.capgemini.app.dao;

import java.util.List;

import com.capgemini.app.dto.TestDto;
import com.capgemini.app.entities.DiagnosticCenter;
import com.capgemini.app.entities.Test;

public interface TestDao {
	public boolean addCenter(TestDto testDto);

	public List<DiagnosticCenter> getAllCenter();

	public DiagnosticCenter getCenter(long centerid);

	public boolean addTest(long centerId, Test test);

	public boolean removeTest(long testId);
}