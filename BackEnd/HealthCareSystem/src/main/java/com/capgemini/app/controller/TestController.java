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
import com.capgemini.app.service.TestService;

@CrossOrigin
@RestController
public class TestController {

	@Autowired
	TestService testService;

	@PostMapping("/addCenter")
	public boolean addCenter(@RequestBody TestDto testDto) {
		
		testService.addCenter(testDto);
		return true;
		
	}

	@DeleteMapping("/removeCenter/{centerId}")
	public boolean removeCenter(@PathVariable long centerId) {
		
			testService.removeCenter(centerId);
			return true;
		
	}

	@GetMapping("/centers")
	public List<DiagnosticCenter> getAllCenter() {
		return testService.getAllCenter();
	}

	@GetMapping("/center/{centerId}")
	public DiagnosticCenter getCenter(@PathVariable long centerId) {
		return testService.getCenter(centerId);
	}

	@PostMapping("/addTest/{centerId}")
	public boolean addTest(@PathVariable long centerId, @RequestBody Test test) {
		return testService.addTest(centerId, test);
	}

	@DeleteMapping("/removeTest/{testId}")
	public boolean removeTest(@PathVariable long testId) {
		return testService.removeTest(testId);
	}
}
