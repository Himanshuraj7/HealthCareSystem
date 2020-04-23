package com.capgemini.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entity.Test;
import com.capgemini.app.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	
	@PostMapping("/addTest")
	public ResponseEntity<Test> addCenter(@RequestBody Test test) {
		testService.addTest(test);
		return new ResponseEntity<Test>(HttpStatus.OK);
	}
	
	@GetMapping("/getAllTest")
    public ResponseEntity<List<Test>> getAllTest() {
			List<Test> list = testService.getAllTest();
			return new ResponseEntity<List<Test>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getTest/{id}")
	public ResponseEntity<Test> retrieveTrainee(@PathVariable long id) {
		List<Test> test=testService.getTest(id);
		if(test!=null)
		return new ResponseEntity<Test>(HttpStatus.OK);
		else
			return new ResponseEntity<Test>(HttpStatus.NOT_FOUND);
		
	}

}
