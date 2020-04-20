package com.capgemini.app.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {
	
//	@ManyToOne(optional = false)
//	@JoinColumn(name="centerId")
//	private DiagnosticCenter center;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
    @SequenceGenerator(sequenceName = "appointment_seq", allocationSize = 1, name = "appointment_seq")
	private BigInteger appointmentId;
	
//	@OneToOne(mappedBy = "appointment")
//	private User user;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private Date datetime;
	
	private boolean approved;
	
//	public DiagnosticCenter getCenter() {
//		return center;
//	}
//	public void setCenter(DiagnosticCenter center) {
//		this.center = center;
//	}
	public BigInteger getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(BigInteger appointmentId) {
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
	public Appointment(BigInteger appointmentId, User user, Date datetime, boolean approved) {
		super();
		this.appointmentId = appointmentId;
		this.user = user;
		this.datetime = datetime;
		this.approved = approved;
	}
	

}
