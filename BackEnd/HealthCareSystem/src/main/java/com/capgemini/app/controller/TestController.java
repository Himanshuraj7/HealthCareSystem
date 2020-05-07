package com.capgemini.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.dto.TestDto;
import com.capgemini.app.entities.DiagnosticCenter;
import com.capgemini.app.entities.Test;
import com.capgemini.app.exceptions.TestException;
import com.capgemini.app.service.TestService;

/************************************************************************************
 * 			@author 		Vishal Mawani
 * 
 *         Description 		Test controller class which provides functionality of
 *         					adding a test, removing a test, viewing diagnostic centers and
 *        					handles the corresponding exceptions.
 * 
 *         Created Date 	27-APR-2020
 ************************************************************************************/
@CrossOrigin
@RestController
public class TestController {

	@Autowired
	TestService testService;

	@PostMapping("/addCenter")
	public boolean addCenter(@RequestBody TestDto testDto) throws TestException {
		try {
			testService.addCenter(testDto);
			return true;
		} catch (Exception exception) {
			throw new TestException(exception.getMessage());
		}

	}

	@PostMapping("/addTest/{centerId}")
	public String addTest(@PathVariable long centerId, @RequestBody Test test) throws TestException {
		try {
			String msg = testService.addTest(centerId, test);
			return msg;
		} catch (Exception exception) {
			throw new TestException(exception.getMessage());
		}
	}

	@DeleteMapping("/removeTest/{testId}")
	public String removeTest(@PathVariable long testId) throws TestException {
		try {
			String msg = testService.removeTest(testId);
			return msg;
		} catch (Exception exception) {
			throw new TestException(exception.getMessage());
		}

	}

	@GetMapping("/centers")
	public List<DiagnosticCenter> getAllCenter() {
		return testService.getAllCenter();
	}

	@GetMapping("/center/{centerId}")
	public DiagnosticCenter getCenter(@PathVariable long centerId) {
		return testService.getCenter(centerId);
	}
}
