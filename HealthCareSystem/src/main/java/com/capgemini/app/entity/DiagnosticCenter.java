package com.capgemini.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="DIAGNOSTIC_CENTER")
@DynamicUpdate(true)
@DynamicInsert(true)
public class DiagnosticCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "center_seq")  
	@SequenceGenerator(name ="center_seq",initialValue=1001, allocationSize = 1)
	private long centerId;
	
	@Column(name="CENTER_NAME", length=20)
	@NotEmpty(message="Center name is mandatory")
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
