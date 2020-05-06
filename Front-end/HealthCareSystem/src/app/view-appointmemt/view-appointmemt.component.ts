import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Appointment } from '../appointment';
import { Router,ActivatedRoute } from '@angular/router';
import {AppointmentDetailsComponent} from '../appointment-details/appointment-details.component'
@Component({
  selector: 'app-view-appointmemt',
  templateUrl: './view-appointmemt.component.html',
  styleUrls: ['./view-appointmemt.component.css']
})
export class ViewAppointmemtComponent implements OnInit {
  appointmentId:number;
  
  constructor(private appointmentService: AppointmentService,private router:Router,
    private route:ActivatedRoute) { }
  
  ngOnInit(): void {
  }
  appointmentDetails(){
    this.router.navigate(['details',this.appointmentId]);
  }
}