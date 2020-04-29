package com.capgemini.app.dao;

import java.util.List;

import com.capgemini.app.entity.Appointment;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.entity.User;

public interface AppointmentDao {
	boolean makeAppointment(Appointment appointment);
	Appointment viewAppointment(long appointmnetId);
	List<Appointment> getAppointmentList();
	DiagnosticCenter view(long centerId);
	Test viewTest(long id);
	boolean approveAppointment(long id);
	User viewUser(long id);
}
