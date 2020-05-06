import { Component} from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  user: User = new User();
  info: String;
  errorInfo: String;

  constructor(private userService: UserService, private route: Router) { }

  signUp() {
    console.log('sign up');
      this.userService.signup(this.user).subscribe(data => {
      this.user = data;

      console.log(this.user);
      alert(this.user);
      this.info = data;
      this.route.navigate(['/login']);
      this.errorInfo = undefined;
      },

      error => {
        this.info = undefined;
        this.errorInfo = error.error;
        console.log(this.errorInfo);
        alert(this.errorInfo);
      } );
  }
}
