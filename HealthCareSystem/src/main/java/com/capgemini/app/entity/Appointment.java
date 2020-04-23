package com.capgemini.app.entity;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENT")
public class Appointment {
	
	@ManyToOne
    @JoinColumn(name="centerId")
	private DiagnosticCenter center;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
    @SequenceGenerator(sequenceName = "appointment_seq", allocationSize = 1, name = "appointment_seq")
	private long appointmentId;
	
//	private Test test;
//	
//	public Test getTest() {
//		return test;
//	}
//	public void setTest(Test test) {
//		this.test = test;
//	}
	private Date datetime;
	
	private boolean approved;
	
	public DiagnosticCenter getCenter() {
		return center;
	}
	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public Appointment() {
		super();
	}
	public Appointment(DiagnosticCenter center, long appointmentId, Date datetime, boolean approved) {
		super();
		this.center = center;
		this.appointmentId = appointmentId;
		
		this.datetime = datetime;
		this.approved = approved;
	}
	
	

}
