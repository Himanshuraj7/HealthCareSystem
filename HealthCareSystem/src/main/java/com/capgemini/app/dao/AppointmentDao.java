package com.capgemini.app.dao;

import java.math.BigInteger;
import java.util.List;

import com.capgemini.app.entity.Appointment;

public interface AppointmentDao {
	boolean makeAppointment(Appointment appointment);
	Appointment viewAppointment(long appointmnetId);
	List<Appointment> getAppointmentList();
}
