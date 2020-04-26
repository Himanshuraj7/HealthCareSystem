package com.capgemini.app.dto;

import com.capgemini.app.entities.Center;

public class TestDto {

	private Center center;

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "TestDto [center=" + center + "]";
	}

	public TestDto(Center center) {

		this.center = center;
	}

	public TestDto() {

	}

}
