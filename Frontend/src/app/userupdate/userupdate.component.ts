import { Component} from '@angular/core';
import { UserService } from '../user.service';
import { Router} from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-userupdate',
  templateUrl: './userupdate.component.html',
  styleUrls: ['./userupdate.component.css']
})
export class UserupdateComponent {

  user : User = new User();
  info : String;
  errorInfo : String;

  constructor(private userService: UserService, private router: Router) { }

  updateUser() {
    console.log('update user');  

    this.userService.updateUser(this.user.userId, this.user.oldEmailId, this.user).subscribe(data => {
      this.info = data;
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
