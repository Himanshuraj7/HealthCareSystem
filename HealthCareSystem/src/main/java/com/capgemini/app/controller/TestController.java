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
import com.capgemini.app.entities.Center;
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
	@PostMapping("/removeCenter/{centerId}")
	public boolean removeCenter(@PathVariable long centerId) {
		return testService.removeCenter(centerId);
	}

	// For displaying all centers along with their test list
	@GetMapping("/centersTests")										//Working
	public List<Center> getAllCenter() {
		return testService.getAllCenter();
	}

	// For displaying a particular center along with its tests available.
	@GetMapping("/center/{centerId}")
	public List<Center> getCenter(@PathVariable long centerId) {							//Working
		return testService.getCenter(centerId);
	}

	// For adding test under a particular center.
	@PostMapping("/addTest/{centerId}")
	public boolean addTest(@PathVariable long centerId, @RequestBody Test test) {					//Working
		return testService.addTest(centerId, test);
	}

	// Another method for getting a particular center along with its tests.
	@GetMapping("/center2/{centerId}")
	public Center getCenter2(@PathVariable long centerId) {								//Working
		return testService.getCenter2(centerId);
	}
	
	@PostMapping("/removeTest/{centerId}")
	public boolean removeTest(@PathVariable long centerId, @RequestBody Test test) {
		return testService.removeTest(centerId, test);
	}
}
