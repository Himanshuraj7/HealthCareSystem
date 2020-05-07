import { Component } from '@angular/core';
import {Router,Route,Routes} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'HealthCareSystem';
  constructor(private router:Router){}

}
