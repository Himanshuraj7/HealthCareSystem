package com.capgemini.app.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENT")
@SequenceGenerator(name ="APPOINTMENT_SEQ",initialValue=1000, allocationSize = 1)
public class Appointment {
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CENTER_ID", nullable = false)
	private DiagnosticCenter center;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
    @SequenceGenerator(sequenceName = "appointment_seq", allocationSize = 1, name = "appointment_seq")
	private BigInteger appointmentId;
	
	private Date datetime;
	
	private boolean approved;
	
	public DiagnosticCenter getCenter() {
		return center;
	}
	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}
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
	

}
