package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.dto.TestDto;
import com.capgemini.app.entities.DiagnosticCenter;
import com.capgemini.app.entities.Test;
import com.capgemini.app.exceptions.TestException;

public interface TestService {

	public boolean addCenter(TestDto testDto) throws TestException;

	public List<DiagnosticCenter> getAllCenter();

	public DiagnosticCenter getCenter(long centerId);

	public String addTest(long centerId, Test test) throws TestException;

	public String removeTest(long testId) throws TestException;

}