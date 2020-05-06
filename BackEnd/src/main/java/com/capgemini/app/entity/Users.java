package com.capgemini.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {
	@Column(length=5)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userseq")
    @SequenceGenerator(sequenceName = "userseq", allocationSize = 1, name = "userseq")
	private long userId;
	
	@Column(length=14)
	private String userPassword;
	
	@Column(length=20)
	private String userName;
	
	@Column(length=10)
	private String contactNo;
	
	@Column(length=5)
	private String userRole;
	
	@Column(length=3)
	private int age;
	
	@Column(length=10)
	private String gender;
	
	@Column(length=30)
	private String emailId;
	
	// getters and setters
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	// constructor
	public Users(long userId, String userPassword, String userName, String contactNo,
			String userRole, int age, String gender, String emailId) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.contactNo = contactNo;
		this.userRole = userRole;
		this.age = age;
		this.gender = gender;
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
