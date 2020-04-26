package com.capgemini.app.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.app.entity.Appointment;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;

@Repository
public class AppointmentDaoImpl implements AppointmentDao{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean makeAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		em.persist(appointment);
		return true;
	}

	@Override
	public Appointment viewAppointment(long appointmentId){
		// TODO Auto-generated method stub
//		Appointment appointment=em.find(Appointment.class, appointmentId);
//		long id=appointment.getTest().getTestId();
//		String Qstr="SELECT appointment.,appointment FROM Appointment appointment having ;
		return em.find(Appointment.class, appointmentId);
		
	}
	@Override
	public DiagnosticCenter view(long centerId){
		// TODO Auto-generated method stub
		return em.find(DiagnosticCenter.class, centerId);
	}
	
	@Override
	public List<Appointment> getAppointmentList() {
		// TODO Auto-generated method stub
		String Qstr="SELECT appointment FROM Appointment appointment";
		TypedQuery<Appointment> query=em.createQuery(Qstr,Appointment.class);
		return query.getResultList();
	}

	@Override
	public Test viewTest(long id) {
		// TODO Auto-generated method stub
		return em.find(Test.class,id);
	}

	@Override
	public Appointment approveAppointment(long id) {
		// TODO Auto-generated method stub
		Appointment appointment=em.find(Appointment.class, id);
		appointment.setApproved(true);
		return appointment;
	}

}
