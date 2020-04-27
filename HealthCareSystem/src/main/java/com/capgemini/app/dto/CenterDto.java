package com.capgemini.app.dto;

import com.capgemini.app.entity.DiagnosticCenter;

public class CenterDto {
	
	private DiagnosticCenter center;

	public DiagnosticCenter getCenter() {
		return center;
	}

	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "CenterDto [center=" + center + "]";
	}

	public CenterDto(DiagnosticCenter center) {
		super();
		this.center = center;
	}

	public CenterDto() {
		
	}
	
	

}
