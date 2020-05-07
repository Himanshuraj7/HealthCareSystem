import { Component, OnInit } from '@angular/core';
import { DiagnosticCenter } from '../diagnostic-center';
import { DiagnosticCenterService } from '../diagnostic-center.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-center',
  templateUrl: './view-center.component.html',
  styleUrls: ['./view-center.component.css']
})
export class ViewCenterComponent implements OnInit {

  centers: Observable<DiagnosticCenter[]>;
  msg:String;
  constructor(private centerService:DiagnosticCenterService,
    private router: Router) { }

ngOnInit(): void {
  this.reloadData();
}
reloadData() {
  this.centerService.loadCenters()
  .subscribe(data=>{
    this.centers=data;
    console.log(data);
  })
}

deleteCenter(centerId: number){
  console.log('Delete Center')

  this.centerService.deleteCenter(centerId)
  .subscribe(
    data=>{
    console.log(data);
    alert(this.msg=data);
    this.reloadData();
  },
  error=>console.log(error));
}

centerDetails(centerId:number){
  this.router.navigate(['details',centerId]);
}

updateCenter(centerId:number){
  this.router.navigate(['update',centerId]);
}


}