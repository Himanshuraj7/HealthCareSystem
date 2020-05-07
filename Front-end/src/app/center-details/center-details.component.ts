import { Component, OnInit } from '@angular/core';
import { DiagnosticCenter, Test } from '../appointment';
import { Router, ActivatedRoute } from '@angular/router';
import { AppointmentService } from '../appointment.service';
@Component({
  selector: 'app-center-details',
  templateUrl: './center-details.component.html',
  styleUrls: ['./center-details.component.css']
})
export class CenterDetailsComponent implements OnInit {

  centerId:number;
  center:DiagnosticCenter;
  test:Test[];
  
  constructor(private route: ActivatedRoute,private router: Router,
    private appointmentService:AppointmentService) { }

  ngOnInit() {
    this.center=new DiagnosticCenter();
      this.centerId = this.route.snapshot.params['centerId'];
      this.appointmentService.getCenter(this.centerId)
      .subscribe(data => {
        console.log(data)
        this.center = data;
      }, error => console.log(error));
  }
  
  dateTimeDetails(testId:number){
    this.router.navigate(['dateTimeDetails',this.centerId,testId]);
  }
}
