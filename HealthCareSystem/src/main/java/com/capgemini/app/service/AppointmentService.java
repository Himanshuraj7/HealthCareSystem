package com.capgemini.app.service;

import java.math.BigInteger;
import java.util.List;

import com.capgemini.app.entity.Appointment;

public interface AppointmentService {
	boolean addAppointment(Appointment appointment);
	Appointment viewAppointment(long appointmentId);
	List<Appointment> viewAppointmentList();
}
