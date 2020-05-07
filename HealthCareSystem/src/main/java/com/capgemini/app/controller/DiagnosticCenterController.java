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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
	
	/************************************************************************************
	 * Method: getAllCenter
     *Description: To View the center details
	 * @param null       - NA
	 * @returns ResponseEntity      - 200,Ok if there is atleast one center is present 
	 * @throws NullException - It is raised due to empty list of center
	 ************************************************************************************/
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
	
	/************************************************************************************
	 * Method: addCenter
     *Description: To add center
	 * @param centerId       - center's id
	 * @returns String      - Center added successfully
	 * @throws NullException - It is raised due to wrong format of data
	 ************************************************************************************/
	@PostMapping("/addCenter")
	public String addCenter(@RequestBody DiagnosticCenter center) {
		try {
		centerService.addCenter(center);
		return ""+center.getCenterName()+" "+"added successfully";
		}
		catch(Exception e) {
			throw new WrongValueException(e.getMessage());
		}
	}
	
	
	/************************************************************************************
	 * Method: removeCenter
     *Description: To remove center details
	 * @param centerId       - center's id
	 * @returns String      - Center deleted successfully
	 * @throws NullException - It is raised due to invalid center id
	 ************************************************************************************/
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
	
	/************************************************************************************
	 * Method: updateCenter
     *Description: To update center details
	 * @param centerId       - center's id
	 * @returns String      - Center updated successfully
	 * @throws NullException - It is raised due to invalid center id
	 ************************************************************************************/
	@PutMapping("updateCenter/{centerId}")
	public String updateCenter(@PathVariable long centerId,@RequestBody DiagnosticCenter center)
	{
		try {
			String message=centerService.updateCenter(center, centerId);
			return message;
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
		
		
	}
	
	/************************************************************************************
	 * Method: addTest
     *Description: To add Test under a particular Diagnostic Center
	 * @param centerId       - center's id
	 * @returns ResponseEntity      - true if center Id is correct and test added successfully
	 * @throws WrongValueException - It is raised due to invalid centerId and wrong format of test 
	 ************************************************************************************/
	@PostMapping("addTest/{centerId}")
	public boolean addTest(@PathVariable long centerId, @RequestBody Test test) {	
		try {
		return centerService.addTest(centerId, test);
		}
		catch(Exception e) {
			throw new WrongValueException(e.getMessage());
		}
	}
	/************************************************************************************
	 * Method: removeTest
     *Description: To remove Test under a particular Diagnostic Center
	 * @param centerId       - test's id
	 * @returns ResponseEntity      - true if test Id is correct
	 * @throws NullException - It is raised due to invalid testId
	 ************************************************************************************/
	@DeleteMapping("/removeTest/{testId}")
	public boolean removeTest(@PathVariable long testId) {	
		try {
		centerService.removeTest(testId);
		return true;
		}
		catch(Exception e) {
			throw new NullException(e.getMessage());
		}
	}

}
