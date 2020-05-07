import { Component, OnInit } from '@angular/core';
import { DiagnosticCenter } from '../diagnostic-center';
import { DiagnosticCenterService } from '../diagnostic-center.service';

@Component({
  selector: 'app-add-center',
  templateUrl: './add-center.component.html',
  styleUrls: ['./add-center.component.css']
})
export class AddCenterComponent implements OnInit {

  center:DiagnosticCenter=new DiagnosticCenter();

  msg:string;
  errorMsg:string;

  constructor(private centerService:DiagnosticCenterService) { }

  ngOnInit(){
    console.log('Add Center')
  }

  addCenter(){
   
    this.centerService.addCenter(this.center).subscribe((data)=>{
      console.log(data);
      this.msg=data;
      this.errorMsg=undefined;
      this.center=new DiagnosticCenter()
      alert(this.msg=data);
    },
      error=>{
      this.errorMsg=JSON.parse(error.error).message;
      console.log(error.error);
      this.msg=undefined});
     
    }

    }
  
  



