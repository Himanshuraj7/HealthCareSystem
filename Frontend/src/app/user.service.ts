import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
    constructor(private http: HttpClient) {}

  public login(emailId : String, userPassword : String, user : User) {
    let url = "http://localhost:8084/login/"+emailId+"/"+userPassword;
    return this.http.post(url, user, {responseType : 'text'});
  }

  public signup(user: User): Observable<any> {
    return this.http.post('http://localhost:8084/register', user, {responseType: 'text'});
  }

  public updateUser(userId : number, emailId : String, user : User): Observable<any> {
    let url = "http://localhost:8084/update/"+userId+"/"+emailId;
    return this.http.put(url, user, {responseType : 'text'});

  }

  public fogotPassword(userId : number, emailId : String, user : User): Observable<any> {
    let url = "http://localhost:8084/forgotPassword/"+userId+"/"+emailId;
    return this.http.put(url, user, {responseType : 'text'});

  }
}
