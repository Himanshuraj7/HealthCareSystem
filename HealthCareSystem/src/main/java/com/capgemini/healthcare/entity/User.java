//package com.capgemini.healthcare.entity;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.SequenceGenerator;
//
//
//@Entity
//@Table(name="user")
//public class User {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bk_seq")
//	@SequenceGenerator(sequenceName = "bk_seq", allocationSize = 1, name = "bk_seq")
//	private String userId;
//	
//	@Column(name="userpassword", length=14)
//	private String userPassword;
//	@Column(name="userrole", length=5)
//	private String userRole;
//	@Column(name="username", length=15)
//	private String userName;
//	@Column(name="emailid", length=20)
//	private String emailId;
//	@Column(name="contactno", length=10)
//	private String contactNo;
//	public List<DiagnosticCenter> centerList;
//	
//	public User(String userId, String userPassword, String userRole, String userName, String emailId, String contactNo) {
//		this.userId = userId;
//		this.userPassword = userPassword;
//		this.userRole = userRole;
//		this.userName = userName;
//		this.emailId = emailId;
//		this.contactNo = contactNo;
//	}
//	
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//	public String getUserPassword() {
//		return userPassword;
//	}
//	public void setUserPassword(String userPassword) {
//		this.userPassword = userPassword;
//	}
//	public String getUserRole() {
//		return userRole;
//	}
//	public void setUserRole(String userRole) {
//		this.userRole = userRole;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public String getEmailId() {
//		return emailId;
//	}
//	public void setEamilId(String emailId) {
//		this.emailId = emailId;
//	}
//	public List<DiagnosticCenter> getCenterList() {
//		return centerList;
//	}
//	public void setCenterList(List<DiagnosticCenter> centerList) {
//		this.centerList = centerList;
//	}
//	public String getContactNo() {
//		return contactNo;
//	}
//	public void setContactNo(String contactNo) {
//		this.contactNo = contactNo;
//	}
//	
//	
//}
