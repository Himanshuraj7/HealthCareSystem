//package com.capgemini.app.entity;
//
//import java.math.BigInteger;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="User")
//public class User {
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
//    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "user_seq")
//	private String userId;
//	
//	@ManyToOne(optional = false)
//	@JoinColumn(name="appointmentId")
//	private Appointment appointment;
//	private String userPassword;
//	private String userName;
//	private BigInteger contactNo;
//	private String userRole;
//	private String emailId;
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//	
//	public Appointment getAppointment() {
//		return appointment;
//	}
//	public void setAppointment(Appointment appointment) {
//		this.appointment = appointment;
//	}
//	public String getUserPassword() {
//		return userPassword;
//	}
//	public void setUserPassword(String userPassword) {
//		this.userPassword = userPassword;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public BigInteger getContactNo() {
//		return contactNo;
//	}
//	public void setContactNo(BigInteger contactNo) {
//		this.contactNo = contactNo;
//	}
//	public String getUserRole() {
//		return userRole;
//	}
//	public void setUserRole(String userRole) {
//		this.userRole = userRole;
//	}
//	public String getEmailId() {
//		return emailId;
//	}
//	public void setEmailId(String emailId) {
//		this.emailId = emailId;
//	}
//
//
//}
