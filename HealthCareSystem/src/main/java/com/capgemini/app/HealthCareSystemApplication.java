package com.capgemini.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.app.entity.Appointment;
import com.capgemini.app.entity.DiagnosticCenter;
import com.capgemini.app.entity.Test;
import com.capgemini.app.entity.User;
import com.capgemini.app.repositery.AppointmentRepositery;
import com.capgemini.app.repositery.DiagnosticCenterRepositery;
import com.capgemini.app.repositery.TestRepositery;
import com.capgemini.app.repositery.UserRepositery;


@SpringBootApplication
public class HealthCareSystemApplication/* implements CommandLineRunner*/{
	
//	@Autowired
//	private DiagnosticCenterRepositery centerRepo;
//	
//	@Autowired
//	private TestRepositery testRepo;
//	
//	@Autowired
//	private UserRepositery userRepo;
//	
//	@Autowired
//	private AppointmentRepositery appointmentRepo;
//	
	public static void main(String[] args) {
		SpringApplication.run(HealthCareSystemApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		DiagnosticCenter center=new DiagnosticCenter();
//		center.setCenterName("AIIMS");
//		centerRepo.save(center);
//		
//		DiagnosticCenter center1=new DiagnosticCenter();
//		center1.setCenterName("Max");
//		centerRepo.save(center1);
//		
//		
//		DiagnosticCenter center3=new DiagnosticCenter();
//		center3.setCenterName("Reliance");
//		centerRepo.save(center3);
//		
//		Test test=new Test();
//		test.setCenter(center1);
//		test.setTestName("Blood Test");
//		testRepo.save(test);
//		
//		User user=new User();
//		//user.setContactNo(null);
//		user.setEmailId("sachin.k.kantiwal");
//		user.setUserName("sachin");
//		user.setUserPassword("123");
//		user.setUserRole("user");
//		userRepo.save(user);
//		
////		User user1=new User();
////		//user1.setContactNo(null);
////		user1.setEmailId("sachin.k.kantiwal");
////		user1.setUserName("sachin");
////		user1.setUserPassword("123");
////		user1.setUserRole("user");
////		userRepo.save(user1);
////		
////		User user2=new User();
////		//user2.setContactNo(null);
////		user2.setEmailId("sachin.k.kantiwal");
////		user2.setUserName("sachin");
////		user2.setUserPassword("123");
////		user2.setUserRole("user");
////		userRepo.save(user2);
//		
//		Appointment app=new Appointment();
//		app.setUser(user);
//		app.setCenter(center);
//		app.setApproved(false);
//		//app.setDatetime(null);
//		appointmentRepo.save(app);
//		
////		Appointment app1=new Appointment();
////		app1.setUser(user1);
////		app1.setCenter(center1);
////		app1.setApproved(false);
////		//app1.setDatetime(null);
////		appointmentRepo.save(app1);
////		
////		Appointment app2=new Appointment();
////		app2.setUser(user2);
////		app2.setCenter(center3);
////		app2.setApproved(false);
////		//app2.setDatetime(null);
////		appointmentRepo.save(app2);
//		
//	}

}
