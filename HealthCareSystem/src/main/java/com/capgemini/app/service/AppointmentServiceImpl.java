package com.capgemini.app.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.app.dao.AppointmentDao;
import com.capgemini.app.entity.Appointment;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.entity.User;
import com.capgemini.app.exception.InvalidException;
import com.capgemini.app.exception.NullException;
import com.capgemini.app.exception.WrongValueException;

/************************************************************************************
 *          @author          Sachin kumar
 *          
 *          Description      It is a Appointment service class that provides the functionality 
 *          				 to find All Appointment,make Appointment,Approve Appointment
                             
 *          Created Date    27-APR-2020
 ************************************************************************************/
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
			throw new NullException("Check again your input data!!!");
		}
	}


	@Override
	public Appointment viewAppointment(long appointmentId) {
		if(dao.viewAppointment(appointmentId)!=null) {
			return dao.viewAppointment(appointmentId);
		}
		else {
			throw new WrongValueException("Wrong Appointment ID!!!");
		}
	}

	@Override
	public List<Appointment> viewAppointmentList() {
		// TODO Auto-generated method stub
		if( dao.getAppointmentList()!=null) {
			return dao.getAppointmentList();
		}
		else {
			throw new NullException("Appointment List is empty!!!");
		}
	
	}

	@Override
	public DiagnosticCenter view(long centerId) {
		if(dao.view(centerId)!=null) {
			return dao.view(centerId);
		}
		else {
			throw new NullException("Wrong CenterID!!!");
		}
		
	}

	@Override
	public Test viewTest(long id) {
		// TODO Auto-generated method stub
		if(dao.viewTest(id)!=null) {
			return dao.viewTest(id);
		}
		else {
			throw new NullException("Wrong TestID!!!");
		}
	}

	@Override
	public boolean approveAppointment(long id) {
		// TODO Auto-generated method stub
		if(dao.approveAppointment(id)) {
			return dao.approveAppointment(id);
		}
		else {
		throw new InvalidException("Appointment is already approved!!!");
		}
	}


	@Override
	public User viewUser(long id) {
		// TODO Auto-generated method stub
		if(dao.viewUser(id)!=null) {
			return dao.viewUser(id);
		}
		else {
			throw new NullException("Wrong UserID!!!");
		}
	}

}
