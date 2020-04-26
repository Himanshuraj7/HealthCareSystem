package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.dto.TestDto;
import com.capgemini.app.entities.Center;
import com.capgemini.app.entities.Test;

public interface TestService {

	public boolean addCenter(TestDto testDto);
	public boolean removeCenter(long centerId);
	public List<Center> getAllCenter();
	public List<Center> getCenter(long centerId);
	public boolean addTest(long centerId,Test test);
	public boolean removeTest(long centerId, Test test);
	public Center getCenter2(long centerId);
}