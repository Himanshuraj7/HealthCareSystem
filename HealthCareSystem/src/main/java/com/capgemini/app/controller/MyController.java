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

import com.capgemini.app.entity.Appointment;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.service.AppointmentService;

@RestController

public class MyController {
	
	@Autowired
	private AppointmentService ser;
	
	@GetMapping("/getAllAppointment")
    public ResponseEntity<List<Appointment>> getAllAppointmentDetails() {
			List<Appointment> listAppointment = ser.viewAppointmentList();
			return new ResponseEntity<List<Appointment>>(listAppointment,HttpStatus.OK);
	}
	
	@PostMapping("/approveAppointment/{AppointmentId}")
    public ResponseEntity<Appointment> approveAppointment(@PathVariable("AppointmentId") long id) {
		Appointment app = ser.approveApp(id);
		return new ResponseEntity<Appointment>(app,HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
		ser.addAppointment(appointment);
		return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
	}
	
	@GetMapping("/getAppointment/{AppointmentId}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("AppointmentId") long id) {
		
		Appointment app = ser.viewAppointment(id);
		if(app.getAppointmentId()==id)
		{
			return new ResponseEntity<Appointment>(app,HttpStatus.OK);	
		}
		return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/getcenter/{centerId}")
    public ResponseEntity<DiagnosticCenter> getCenterById(@PathVariable("centerId") long id) {
		
		DiagnosticCenter center = ser.view(id);
		if(center.getCenterId()==id)
		{
			return new ResponseEntity<DiagnosticCenter>(center,HttpStatus.OK);
		}
		return new ResponseEntity<DiagnosticCenter>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/gettest/{testId}")
    public ResponseEntity<Test> getTestById(@PathVariable("testId") long id) {
		
		Test test= ser.viewTest(id);
		if(test.getTestId()==id)
		{
			return new ResponseEntity<Test>(test,HttpStatus.OK);
		}
		return new ResponseEntity<Test>(HttpStatus.NOT_FOUND);
	}
}
