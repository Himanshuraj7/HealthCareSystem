import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Appointment } from '../appointment';
import {ActivatedRoute, Router} from '@angular/router'
@Component({
  selector: 'app-appointment-details',
  templateUrl: './appointment-details.component.html',
  styleUrls: ['./appointment-details.component.css']
})
export class AppointmentDetailsComponent implements OnInit {
  appointment:Appointment;
  appointmentId:number;
  constructor(private appointmentService:AppointmentService, private route:ActivatedRoute) { }

  ngOnInit() {
    this.appointment=new Appointment();
    this.appointmentId=this.route.snapshot.params['appointmentId'];
    this.appointmentService.getAppointmentById(this.appointmentId).subscribe(
      data=>{
        this.appointment=data;
        console.log(data);
      },error => console.log(error));
  }
}
