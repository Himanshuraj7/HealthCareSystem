package com.capgemini.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.app.dao.AppointmentDao;
import com.capgemini.app.entity.Appointment;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.exception.InvalidException;
import com.capgemini.app.exception.WrongValueException;
@Transactional
@Service
public class AppointmentServiceImpl implements AppointmentService{
	@Autowired
	private AppointmentDao dao;
	
	@Override
	public boolean addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		if(dao.makeAppointment(appointment)) {
			return true;
		}
		else {
			throw new InvalidException("Check again your input data!!!");
		}
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

	@Override
	public DiagnosticCenter view(long centerId) {
		// TODO Auto-generated method stub
		return dao.view(centerId);
	}

	@Override
	public Test viewTest(long id) {
		// TODO Auto-generated method stub
		return dao.viewTest(id);
	}

	@Override
	public Appointment approveApp(long id) {
		// TODO Auto-generated method stub
		return dao.approveAppointment(id);
	}

}
