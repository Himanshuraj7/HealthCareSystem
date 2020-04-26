package com.capgemini.app.dao;

import java.util.List;

import com.capgemini.app.dto.TestDto;
import com.capgemini.app.entities.Center;
import com.capgemini.app.entities.Test;

public interface TestDao {
public boolean addCenter(TestDto testDto);
public boolean removeCenter(long centerId);
public List<Center> getAllCenter();
public List<Center> getCenter(long centerid);
public boolean addTest(long centerId,Test test);
public Center getCenter2(long centerId);
public boolean removeTest(long centerId, Test test);
}