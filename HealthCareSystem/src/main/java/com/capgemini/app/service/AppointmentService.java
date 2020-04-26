package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.entity.Appointment;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;

public interface AppointmentService {
	boolean addAppointment(Appointment appointment);
	Appointment viewAppointment(long appointmentId);
	List<Appointment> viewAppointmentList();
	DiagnosticCenter view(long centerId);
	Test viewTest(long id);
	Appointment approveApp(long id);
}
