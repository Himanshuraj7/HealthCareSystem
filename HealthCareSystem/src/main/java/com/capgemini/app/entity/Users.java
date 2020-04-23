package com.capgemini.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="USERS")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userseq")
    @SequenceGenerator(sequenceName = "userseq", allocationSize = 1, name = "userseq")
	private long userId;
	
	@OneToOne(mappedBy = "user")
	private Appointment appointment;
	
	@NotEmpty(message="password is mandatory")
	@Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,14}$", message=": Password must contain one number,one alphabet,one special character and size should be at least 8 characters and not more than 14 characters")
	private String userPassword;
	
	@NotEmpty(message="username is mandatory")
	@Column(name="username", length=20)
	private String userName;
	
	@NotEmpty(message="contact number is mandatory" + "\n")
	@Size(min=10, max=10, message="contact number size must be 10")
	private String contactNo;
	
	private String userRole;
	
	@NotEmpty(message="email id is mandatory")
	private String emailId;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public Users(long userId, String userPassword, String userName, 
			String contactNo, String userRole, String emailId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.contactNo = contactNo;
		this.userRole = userRole;
		this.emailId = emailId;
	}

	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", contactNo="
				+ contactNo + ", userRole=" + userRole + ", emailId=" + emailId + "]";
	}
	
	
}
