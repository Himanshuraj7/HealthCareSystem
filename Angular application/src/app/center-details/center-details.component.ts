import { Component, OnInit } from '@angular/core';
import { DiagnosticCenter, Test } from '../diagnostic-center';
import { Router, ActivatedRoute } from '@angular/router';
import { DiagnosticCenterService } from '../diagnostic-center.service';

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
    private centerService:DiagnosticCenterService) { }

  ngOnInit() {
    this.center=new DiagnosticCenter();
    this.centerId = this.route.snapshot.params['centerId'];
    this.diagnosticCenterDetails(this.centerId);
  }

  diagnosticCenterDetails(centerId : number){
    this.centerService.getCenter(this.centerId)
      .subscribe(data => {
        console.log(data);
        this.center = data;
    });
  }

  list(){
    this.router.navigate(['view']);
  }
  updateCenter(centerId:number){
    this.router.navigate(['update',centerId]);
  }

  removeTest(testId : number){
    this.centerService.removeTest(testId).subscribe(
      data=>{
        console.log(data);
        this.diagnosticCenterDetails(this.centerId);
        alert("Test Deleted Successfully");
      });
  }

  addTest(centerId :number){
    this.router.navigate(['addTests',centerId]);
  }
}