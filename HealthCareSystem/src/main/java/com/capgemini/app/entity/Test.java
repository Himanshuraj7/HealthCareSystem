package com.capgemini.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="TEST")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "test_seq")
	@SequenceGenerator(name ="test_seq",initialValue=101, allocationSize = 1)
	private long testId;
	
	@Column(name="TEST_NAME",length=20)
	private String testName;
	
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



	public Test(long testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}

	public Test() {
		super();
	}

}
