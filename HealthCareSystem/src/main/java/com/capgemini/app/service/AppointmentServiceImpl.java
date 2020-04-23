package com.capgemini.app.service;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.app.dao.AppointmentDao;
import com.capgemini.app.entity.Appointment;
@Transactional
@Service
public class AppointmentServiceImpl implements AppointmentService{
	@Autowired
	private AppointmentDao dao;
	
	@Override
	public boolean addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return dao.makeAppointment(appointment);
	}

	@Override
	
	public Appointment viewAppointment(long appointmentId) {
		return dao.viewAppointment(appointmentId);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Appointment> viewAppointmentList() {
		// TODO Auto-generated method stub
		return dao.getAppointmentList();
	}

}
