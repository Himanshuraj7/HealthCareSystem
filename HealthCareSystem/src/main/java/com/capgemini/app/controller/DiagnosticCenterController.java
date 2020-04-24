package com.capgemini.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.service.DiagnosticCenterService;

@RestController
@CrossOrigin
public class DiagnosticCenterController {
	
	@Autowired
	private DiagnosticCenterService centerService;
	
	@GetMapping("/getAllCenter")
    public ResponseEntity<List<DiagnosticCenter>> getAllCenter() {
			List<DiagnosticCenter> list = centerService.getAllCenter();
			return new ResponseEntity<List<DiagnosticCenter>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/addCenter")
	public ResponseEntity<DiagnosticCenter> addCenter(@RequestBody DiagnosticCenter center) {
		centerService.addCenter(center);
		return new ResponseEntity<DiagnosticCenter>(HttpStatus.OK);
	}
	
	@DeleteMapping("/removeCenter/{centerId}")
    public ResponseEntity<DiagnosticCenter> removeCenter(@PathVariable("centerId") long id) {
		
		centerService.removeCenter(id);
		return new ResponseEntity<DiagnosticCenter>(HttpStatus.OK);
	}
	
	@GetMapping("/getCenter/{centerId}")
    public ResponseEntity<DiagnosticCenter> getCenter(@PathVariable("centerId") long id) {
		DiagnosticCenter center= centerService.getCenter(id);
		if(center!=null)
			return new ResponseEntity<DiagnosticCenter>(center,HttpStatus.OK);
		else
			return new ResponseEntity<DiagnosticCenter>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getAllTest")
    public ResponseEntity<List<Test>> getAllTest() {
			List<Test> list = centerService.getAllTest();
			return new ResponseEntity<List<Test>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getTest/{id}")
	public ResponseEntity<List<Test>> retrieveTrainee(@PathVariable long id) {
		List<Test> test=centerService.getTest(id);
		if(test!=null)
		return new ResponseEntity<List<Test>>(test,HttpStatus.OK);
		else
			return new ResponseEntity<List<Test>>(test,HttpStatus.NOT_FOUND);
		
	}


}
