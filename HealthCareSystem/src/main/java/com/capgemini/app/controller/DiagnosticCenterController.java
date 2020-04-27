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

import com.capgemini.app.dto.CenterDto;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.exception.NullException;
import com.capgemini.app.exception.WrongValueException;
import com.capgemini.app.service.DiagnosticCenterService;
/************************************************************************************
 *          @author          Ashish kumar
 *          
 *          Description      It is a Diagnostic center controller class that provides the functionality 
 *          				 to interact customer to our product and return to the requests to frontend
                             
  *         Created Date    27-APR-2020
 ************************************************************************************/
@RestController
@CrossOrigin
public class DiagnosticCenterController {
	
	@Autowired
	private DiagnosticCenterService centerService;
	
	@GetMapping("/getAllCenter")
    public ResponseEntity<List<DiagnosticCenter>> getAllCenter() {
		try {
			List<DiagnosticCenter> list = centerService.getAllCenter();
			return new ResponseEntity<List<DiagnosticCenter>>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
	}
	
	@PostMapping("/addCenter")
	public boolean addCenter(@RequestBody CenterDto center) {
		try {
		centerService.addCenter(center);
		return true;
		}
		catch(Exception e) {
			throw new WrongValueException(e.getMessage());
		}
	}
	
	@DeleteMapping("/removeCenter/{centerId}")
    public String removeCenter(@PathVariable("centerId") long id) {
		try {
		centerService.removeCenter(id);
		return "Center Deleted Successfully";
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
	}
	/************************************************************************************
	 * Method: getCenter
     *Description: To view center and tests present under it
	 * @param centerId       - center's id
	 * @returns ResponseEntity      - 200 OK, if centerId exists
	 * @throws NullException - It is raised due to invalid center id
	 ************************************************************************************/

	@GetMapping("/getCenter/{centerId}")
    public ResponseEntity<DiagnosticCenter> getCenter(@PathVariable("centerId") long id) {
		DiagnosticCenter center= centerService.getCenter(id);
		try {
		if(center!=null)
			return new ResponseEntity<DiagnosticCenter>(center,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
		return new ResponseEntity<DiagnosticCenter>(center,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getAllTest")
    public ResponseEntity<List<Test>> getAllTest() {
		try {
			List<Test> list = centerService.getAllTest();
			return new ResponseEntity<List<Test>>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
		
	}
	
	@GetMapping("/getTest/{id}")
	public ResponseEntity<List<Test>> getTest(@PathVariable long id) {
		List<Test> test=centerService.getTest(id);
		try {
		if(test!=null)
		return new ResponseEntity<List<Test>>(test,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
			return new ResponseEntity<List<Test>>(test,HttpStatus.NOT_FOUND);
		
	}
	
	/************************************************************************************
	 * Method: addTest
     *Description: To view center and tests present under it
	 * @param centerId       - center's id
	 * @returns String     	 - test added successfully, if centerId is present
	 * @throws NullException - It is raised if centerId doesnot exists
	 ************************************************************************************/
	@PostMapping("addTest/{centerId}")
	public String addTest(@PathVariable (value="centerId") long centerId,
						@RequestBody Test test) {
		try {
		centerService.addTest(centerId,test);
		return "test added succesfully in center";
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
		
	}
	
	@DeleteMapping("/removeTest/{testId}")
    public String removeTest(@PathVariable("testId") long id) {
		try {
		centerService.removeTest(id);
		return "Test deleted successfully";
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
	}


}
