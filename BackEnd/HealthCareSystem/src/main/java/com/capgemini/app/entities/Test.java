package com.capgemini.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/************************************************************************************
 *          @author          Vishal Mawani
 *          
 *          Description      Test Entity class provides all the variables and contains respective
 *          				 getters and setters and constructors.
                             
  *         Created Date    27-APR-2020
 ************************************************************************************/
@Entity
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "testId_generator")
	@SequenceGenerator(name = "testId_generator", initialValue = 101, allocationSize = 1)
	private long testId;

	@Column(length = 25)
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

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + "]";
	}

	public Test(long testId, String testName) {

		this.testId = testId;
		this.testName = testName;
	}

	public Test() {

	}

	@Override
	public boolean equals(Object obj) {

		return super.equals(obj);
	}

}
