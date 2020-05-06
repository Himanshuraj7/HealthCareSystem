import { Injectable } from '@angular/core';
import { HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Appointment1 } from './appointment1';

@Injectable({
  providedIn: 'root'
})

export class AppointmentService {
  private baseUrl = 'http://localhost:8084/addAppointment';
  private baseUrl1 = 'http://localhost:8084/approveAppointment';
  private baseUrl2 = 'http://localhost:8084/getAppointmentById';
  private baseUrl3 = 'http://localhost:8084/getCenter';
  private baseUrl4 = 'http://localhost:8084/getAllCenters';
  private baseUrl5 = 'http://localhost:8084/getTest';
  private baseUrl6 = 'http://localhost:8084/getUser';
  private baseUrl7 = 'http://localhost:8084/getAllAppointment';
  
  constructor(private http: HttpClient) { }

  loadAppointments(): Observable<any>{
    return this.http.get("http://localhost:8084/getAllAppointment");
  }

  public addAppointment(appointment:Appointment1):Observable<any>{
    console.log(appointment);
    return this.http.post("http://localhost:8084/addApointment",appointment,
    {responseType:'text'});
  } 

  approveAppointment(appointmentId:number): Observable<any> {
    let url="http://localhost:8084/approveAppointment/"+appointmentId;
    return this.http.put(url,{responseType:'text'});
  }

  public getAppointmentById(appointmentId:number):Observable<any>{
    return this.http.get("http://localhost:8084/getAppointment/"+appointmentId);
  }

  getCenter(centerId: number): Observable<any> {
    return this.http.get(`${this.baseUrl3}/${centerId}`);
  }

  getTestById(testId:number):Observable<any>{
    return this.http.get(`${this.baseUrl5}/${testId}`);
  }

  getUserById(userId:number):Observable<any>{
    return this.http.get(`${this.baseUrl6}/${userId}`);
  }
  
  loadCenters(): Observable<any>{
    return this.http.get("http://localhost:8084/getAllCenters");
  }
}
