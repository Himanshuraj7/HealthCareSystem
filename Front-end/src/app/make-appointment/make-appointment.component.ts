import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { DiagnosticCenter, Appointment } from '../appointment';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Component({
  selector: 'app-make-appointment',
  templateUrl: './make-appointment.component.html',
  styleUrls: ['./make-appointment.component.css']
})
export class MakeAppointmentComponent implements OnInit {
 
  centers: Observable<DiagnosticCenter[]>;
  msg:String;
  public popoverTitle:string;
  public popoverMessage:string;
  public confirmClicked:boolean=false;
  public cancelClicked:boolean=false;
  constructor(private appointmentService:AppointmentService,
  private router: Router) { }

ngOnInit(): void {
  this.reloadData();
}
reloadData() {
  this.centers = this.appointmentService.loadCenters();
  
}
centerDetails(centerId:number){
  this.router.navigate(['centerDetails',centerId]);
}

}
