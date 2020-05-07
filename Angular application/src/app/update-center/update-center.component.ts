import { Component, OnInit } from '@angular/core';
import { DiagnosticCenter } from '../diagnostic-center';
import { ActivatedRoute, Router } from '@angular/router';
import { DiagnosticCenterService } from '../diagnostic-center.service';

@Component({
  selector: 'app-update-center',
  templateUrl: './update-center.component.html',
  styleUrls: ['./update-center.component.css']
})
export class UpdateCenterComponent implements OnInit {
  centerId: number;
  center:DiagnosticCenter;
  msg:string;


  constructor(private route: ActivatedRoute,private router: Router,
    private centerService:DiagnosticCenterService) { }

    ngOnInit(){
      this.center=new DiagnosticCenter();
  
      this.centerId = this.route.snapshot.params['centerId'];
      
      this.centerService.getCenter(this.centerId)
        .subscribe(data => {
          console.log(data)
          this.center = data;
        }, error => console.log(error));
    }
  
    updateCenter() {
      this.centerService.updateCenter(this.centerId,this.center)
        .subscribe(data => console.log(data), 
        error => console.log(error));
      this.center = new DiagnosticCenter() 
      alert("Center Details Updated Successfully");
      this.gotoList();
    }
  
    onSubmit() {
      this.updateCenter();    
    }
  
    gotoList() {
      this.router.navigate(['/view']);
    }
  }
  
