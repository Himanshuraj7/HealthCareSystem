package com.capgemini.app.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;
import com.capgemini.app.entity.Appointment;
import com.capgemini.app.exception.AppointmentException;


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
	public Appointment viewAppointment(long appointmentId) throws AppointmentException {
		// TODO Auto-generated method stub
		Appointment appointment= em.find(Appointment.class, appointmentId);
		if(appointment==null) {
			throw new AppointmentException("Appointment id does not exist"+appointmentId);
		}
		return appointment;
	}

	@Override
	public List<Appointment> getAppointmentList() {
		// TODO Auto-generated method stub
		String Qstr="SELECT appointment FROM Appointment appointment";
		TypedQuery<Appointment> query=em.createQuery(Qstr,Appointment.class);
		return query.getResultList();
	}

}
