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


}
