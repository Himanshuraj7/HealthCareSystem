import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AppointmentService } from '../appointment.service';
import { Appointment, DiagnosticCenter,Test,User } from '../appointment';
import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Appointment1 } from '../appointment1';

@Component({
  selector: 'app-date-time',
  templateUrl: './date-time.component.html',
  styleUrls: ['./date-time.component.css']
})
export class DateTimeComponent implements OnInit { 
  appointment:Appointment1=new Appointment1();
 
  msg:any;
  errorMsg:string;
  constructor(private http:HttpClient, private appointmentService:AppointmentService,
    public datepipe: DatePipe,private route: ActivatedRoute) { }  
  ngOnInit(): void {
 
    
    this.appointment.centerId = this.route.snapshot.params['centerId'];
    this.appointment.testId = this.route.snapshot.params['testId'];
    this.appointment.userId=8;

  }

  addAppointment(){
    this.appointmentService.addAppointment(this.appointment).subscribe((data)=>{
      console.log(data);
      this.msg=data;
      this.errorMsg=undefined;
      alert(this.msg=data);
    },
      error=>{
      this.errorMsg=JSON.parse(error.error).message;
      console.log(error.error);
      this.msg=undefined});  
    }
}