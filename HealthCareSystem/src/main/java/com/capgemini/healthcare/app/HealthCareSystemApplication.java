package com.capgemini.healthcare.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.healthcare.entity.DiagnosticCenter;
import com.capgemini.healthcare.entity.Test;
import com.capgemini.healthcare.repository.DiagnosticCenterRepository;
import com.capgemini.healthcare.repository.TestRepository;

@SpringBootApplication
public class HealthCareSystemApplication implements CommandLineRunner{
	
	@Autowired
	private DiagnosticCenterRepository centerRepo;
	
	@Autowired
	private TestRepository testRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(HealthCareSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		DiagnosticCenter center=new DiagnosticCenter();
		center.setCenterName("AIIMS");
		centerRepo.save(center);
		
		DiagnosticCenter center1=new DiagnosticCenter();
		center1.setCenterName("Max");
		centerRepo.save(center1);
		
		
		DiagnosticCenter center3=new DiagnosticCenter();
		center3.setCenterName("Reliance");
		centerRepo.save(center3);
		
		Test test=new Test();
		test.setCenter(center1);
		test.setTestName("Blood Test");
		testRepo.save(test);
		
	}

}
