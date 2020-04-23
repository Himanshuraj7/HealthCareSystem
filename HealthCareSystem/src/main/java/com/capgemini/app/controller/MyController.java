package com.capgemini.app.controller;

import java.math.BigInteger;
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
}
