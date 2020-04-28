package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.dto.TestDto;
import com.capgemini.app.entities.DiagnosticCenter;
import com.capgemini.app.entities.Test;

public interface TestService {

	public boolean addCenter(TestDto testDto);
	public boolean removeCenter(long centerId);
	public List<DiagnosticCenter> getAllCenter();
	public List<DiagnosticCenter> getOnlyCenter();
	public List<DiagnosticCenter> getCenter(long centerId);
	public boolean addTest(long centerId,Test test);
	public boolean removeTest(long testId);
	public DiagnosticCenter getCenter2(long centerId);
}