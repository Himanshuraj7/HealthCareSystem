//package com.capgemini.healthcare.entity;
//
//import java.math.BigInteger;
//import java.time.LocalDateTime;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.SequenceGenerator;
//
//@Entity
//@Table(name="appointment")
//public class Appointment {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bk_seq")
//	@SequenceGenerator(sequenceName = "bk_seq", allocationSize = 1, name = "bk_seq")
//	private BigInteger appointmentId;
//	
//	private User user;
//	private Test test;
//	private LocalDateTime dateTime;
//	private boolean approved;
//	
//	public Appointment(User user, BigInteger appointmentId, Test test, LocalDateTime dateTime, boolean approved) {
//		super();
//		this.user = user;
//		this.appointmentId = appointmentId;
//		this.test = test;
//		this.dateTime = dateTime;
//		this.approved = approved;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public BigInteger getAppointmentId() {
//		return appointmentId;
//	}
//
//	public void setAppointmentId(BigInteger appointmentId) {
//		this.appointmentId = appointmentId;
//	}
//
//	public Test getTest() {
//		return test;
//	}
//
//	public void setTest(Test test) {
//		this.test = test;
//	}
//
//	public LocalDateTime getDateTime() {
//		return dateTime;
//	}
//
//	public void setDateTime(LocalDateTime dateTime) {
//		this.dateTime = dateTime;
//	}
//
//	public boolean isApproved() {
//		return approved;
//	}
//
//	public void setApproved(boolean approved) {
//		this.approved = approved;
//	}
//}
