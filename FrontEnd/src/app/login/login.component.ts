import { Component } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {
  
  user: User= new User();
  info: string;
  errorInfo: string;

  constructor(private userService: UserService, private route: Router) { }
  
  login() {
    console.log('log in');  

    this.userService.login(this.user.emailId, this.user.userPassword, this.user).subscribe(data => {
      this.info=data;
       alert(this.info);
       this.route.navigate(['/userupdate']);
      },

      error => {
        this.info = undefined;
        this.errorInfo = error.error; 
        console.log(this.errorInfo);
        alert(this.errorInfo);
      } );
  }

  forgotPassword(){
    this.route.navigate(['/fogotpassword']);
  }
}