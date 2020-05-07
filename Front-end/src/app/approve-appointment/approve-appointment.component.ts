import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Appointment } from '../appointment';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Component({
  selector: 'app-approve-appointment',
  templateUrl: './approve-appointment.component.html',
  styleUrls: ['./approve-appointment.component.css']
})
export class ApproveAppointmentComponent implements OnInit {
  appointment:Appointment=new Appointment();
  message:String="Appointment Approved!!";
  info: string;
  errorInfo: string="Appointment Approved";
  appointments:Appointment[];
  constructor(private appointmentService:AppointmentService,private router: Router) { }

  ngOnInit(): void {
    this.appointmentService.loadAppointments().subscribe(
      (data:Appointment[])=>this.appointments=data
    );
  }
  
  approveAppointment(appointmentID:number){
    console.log('Approving');
    this.appointmentService.approveAppointment(appointmentID).subscribe(
        data=>{
          this.message=data;
          console.log(this.message);
          console.log(data);
          alert(this.message);
          
        },
        error => {
          this.info = undefined;
          console.log(this.errorInfo);
          alert(this.errorInfo);
        }
    );
  }
}
