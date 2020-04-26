package com.capgemini.app;

import java.util.Date;

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
//	
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
//
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
//		test.setTestName("Corona");
//		test.setCenter(center);
//		testRepo.save(test);
//		
//		Test test1=new Test();
//		test1.setTestName("maleria");
//		test1.setCenter(center);
//		testRepo.save(test1);
//		
//		Test test2=new Test();
//		test2.setTestName("typhoid");
//		test2.setCenter(center);
//		testRepo.save(test2);
//		
//		Test test3=new Test();
//		test3.setTestName("typhoid");
//		test3.setCenter(center1);
//		testRepo.save(test3);
//		
//		Test test4=new Test();
//		test4.setTestName("typhoid");
//		test4.setCenter(center1);
//		testRepo.save(test4);
//
//		Test test5=new Test();
//		test5.setTestName("typhoid");
//		test5.setCenter(center3);
//		testRepo.save(test5);
//		
//		Date date= new Date();
//		Appointment app=new Appointment();
//		app.setApproved(true);
//		app.setDatetime(date);
//		app.setTest(test);
//		appointmentRepo.save(app);
//		
//		Appointment app1=new Appointment();
//		app1.setApproved(true);
//		app1.setDatetime(date);
//		app1.setTest(test1);
//		appointmentRepo.save(app1);
//		
//		Appointment app2=new Appointment();
//		app2.setApproved(true);
//		app2.setDatetime(date);
//		app2.setTest(test2);
//		appointmentRepo.save(app2);
//
//		Appointment app3=new Appointment();
//		app3.setApproved(true);
//		app3.setDatetime(date);
//		app3.setTest(test3);
//		appointmentRepo.save(app3);
//		
//		Appointment app4=new Appointment();
//		app4.setApproved(true);
//		app4.setDatetime(date);
//		app4.setTest(test4);
//		appointmentRepo.save(app4);
//		
//		Appointment app5=new Appointment();
//		app5.setApproved(true);
//		app5.setDatetime(date);
//		app5.setTest(test5);
//		appointmentRepo.save(app5);
//		
//		User user=new User();
//		user.setContactNo("839684");
//		user.setEmailId("sachin.");
//		user.setUserName("sachin");
//		user.setUserPassword("123");
//		user.setUserRole("user");
//		user.setAppointment(app);
//		userRepo.save(user);
//		
//		User user1=new User();
//		user1.setContactNo("839684");
//		user1.setEmailId("sachin.");
//		user1.setUserName("sachin");
//		user1.setUserPassword("123");
//		user1.setUserRole("user");
//		user1.setAppointment(app1);
//		userRepo.save(user1);
//		
//		User user2=new User();
//		user2.setContactNo("839684");
//		user2.setEmailId("sachin.");
//		user2.setUserName("sachin");
//		user2.setUserPassword("123");
//		user2.setUserRole("user");
//		user2.setAppointment(app2);
//		userRepo.save(user2);
//		
//		User user3=new User();
//		user3.setContactNo("839684");
//		user3.setEmailId("sachin.");
//		user3.setUserName("sachin");
//		user3.setUserPassword("123");
//		user3.setUserRole("user");
//		user3.setAppointment(app3);
//		userRepo.save(user3);
//		
//		User user4=new User();
//		user4.setContactNo("839684");
//		user4.setEmailId("sachin.");
//		user4.setUserName("sachin");
//		user4.setUserPassword("123");
//		user4.setUserRole("user");
//		user4.setAppointment(app4);
//		userRepo.save(user4);
//
//	}

}
