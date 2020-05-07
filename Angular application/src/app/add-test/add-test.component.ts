import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DiagnosticCenterService } from '../diagnostic-center.service';
import { Test } from '../diagnostic-center';

@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css']
})
export class AddTestComponent implements OnInit {

  centerId :number;
  test: Test = new Test();
  msg:boolean=false;
  constructor(private centerService:DiagnosticCenterService, private route : ActivatedRoute,
     private router : Router) { }

  ngOnInit(): void {
    this.centerId = this.route.snapshot.params['centerId'];
  }

  addTest(){
    this.centerService.addTest(this.centerId,this.test).subscribe((data)=>{
      console.log(data);
      this.msg=true;
    })
  }

}
