import { Component} from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-fogotpassword',
  templateUrl: './fogotpassword.component.html',
  styleUrls: ['./fogotpassword.component.css']
})
export class FogotpasswordComponent {

  user : User = new User();
  info : String;
  errorInfo : String;

  constructor(private userService: UserService, private router: Router) { }

  forgetPass() {
    console.log('forgot pass');  

    this.userService.fogotPassword(this.user.userId, this.user.emailId, this.user).subscribe(data => {
      this.info =data;
      alert(this.info);
      },

      error => {
        this.info = undefined;
        this.errorInfo = error.error; 
        console.log(this.errorInfo);
        alert(this.errorInfo);
      } );
  }

}
