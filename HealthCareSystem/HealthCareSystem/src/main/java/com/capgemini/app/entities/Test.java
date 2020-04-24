package com.capgemini.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TEST")
@DynamicUpdate(true)
@DynamicInsert(true)
@SequenceGenerator(name = "test_seq", initialValue = 101, allocationSize = 1)
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_seq")
	private long testId;

	private String testName;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE }, optional = false)
	@JoinColumn(name = "CENTER_ID", nullable = false)
	private DiagnosticCenter center;

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public DiagnosticCenter getCenter() {
		return center;
	}

	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}

	public Test(long testId, String testName, DiagnosticCenter center) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.center = center;
	}

	public Test() {
		super();
	}

}
