package com.capgemini.app.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.app.entity.Appointment;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.entity.User;

/************************************************************************************
 *          @author          Sachin kumar
 *          
 *          Description      It is a Appointment dao class that provides the functionality 
 *          				 to persist new Appointment,make an appointment,approve an appointment 
                             
  *         Created Date    27-APR-2020
 ************************************************************************************/

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
		String Qstr="SELECT appointment FROM Appointment appointment";
		TypedQuery<Appointment> query=em.createQuery(Qstr,Appointment.class);
		List<Appointment>list =query.getResultList();
		Appointment container = new Appointment();
		for (Appointment row : list) {
		    if(row.getAppointmentId()==appointmentId) {
		    	container=row;
		    	break;
		    }
		}
		return container;
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
	public boolean approveAppointment(long id) {
		// TODO Auto-generated method stub
		Appointment appointment=em.find(Appointment.class, id);
		appointment.setApproved(true);
		return true;
	}

	@Override
	public User viewUser(long id) {
		// TODO Auto-generated method stub
		return em.find(User.class,id);
	}

}
