package com.capgemini.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
public class TestController {

	@Autowired
	TestService testService;

	// For adding a center along with list of tests
	@PostMapping("/addCenter")
	public boolean addCenter(@RequestBody TestDto testDto) {					//Working
		return testService.addCenter(testDto);

	}
	//Removes a particular test according to given centerId along with the tests available inside the center
	@PostMapping("/removeCenter/{centerId}")
	public boolean removeCenter(@PathVariable long centerId) {								//Working
		return testService.removeCenter(centerId);
	}

	// For displaying all centers along with their test list
	@GetMapping("/centersTests")										//Working
	public List<DiagnosticCenter> getAllCenter() {
		return testService.getAllCenter();
	}
	
	@GetMapping("/centers")
	public List<DiagnosticCenter> getOnlyCenter(){
		return testService.getOnlyCenter();
	}

	// For displaying a particular center along with its tests available.
	@GetMapping("/center/{centerId}")
	public List<DiagnosticCenter> getCenter(@PathVariable long centerId) {							//Working
		return testService.getCenter(centerId);
	}

	// For adding test under a particular center.
	@PostMapping("/addTest/{centerId}")
	public boolean addTest(@PathVariable long centerId, @RequestBody Test test) {					//Working
		return testService.addTest(centerId, test);
	}

	// Another method for getting a particular center along with its tests.
	@GetMapping("/center2/{centerId}")
	public DiagnosticCenter getCenter2(@PathVariable long centerId) {								//Working
		return testService.getCenter2(centerId);
	}
	//Method for removing a particular test under a center using its test id
	@PostMapping("/removeTest/{testId}")
	public boolean removeTest(@PathVariable long testId) {					//Working
		return testService.removeTest(testId);
	}
}
