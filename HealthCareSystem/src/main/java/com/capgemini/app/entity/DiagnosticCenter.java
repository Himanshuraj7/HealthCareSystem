package com.capgemini.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="DIAGNOSTIC_CENTER")
@SequenceGenerator(name ="center_seq",initialValue=1001, allocationSize = 1)
public class DiagnosticCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "center_seq")  
	private long centerId;
	
	@Column(name="CENTER_NAME")
	private String centerName;
	

	public long getCenterId() {
		return centerId;
	}

	public void setCenterId(long centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public DiagnosticCenter(long centerId, String centerName) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
	}

	public DiagnosticCenter() {
		super();
	}

}
