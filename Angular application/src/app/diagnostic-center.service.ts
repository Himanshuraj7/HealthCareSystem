import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { DiagnosticCenter, Test } from './diagnostic-center';

@Injectable({
  providedIn: 'root'
})
export class DiagnosticCenterService {

  private baseUrl = 'http://localhost:8084/getCenter';
  private baseUrl2 = 'http://localhost:8084/removeCenter';
  private baseUrl3 = 'http://localhost:8084/updateCenter';
  private baseUrl4 = 'http://localhost:8084/addTest';
  private baseUrl5 = 'http://localhost:8084/removeTest';

  constructor(private http:HttpClient) { }
  loadCenters(): Observable<any>{
    return this.http.get("http://localhost:8084/getAllCenter");
  }

  public addCenter(center:DiagnosticCenter):Observable<any>{
    return this.http.post("http://localhost:8084/addCenter",center,{responseType:'text'});
  } 

  getCenter(centerId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${centerId}`);
  }

  public deleteCenter(centerId:number):Observable<any>{
    return this.http.delete(`${this.baseUrl2}/${centerId}`, { responseType: 'text' });
  }

  updateCenter(centerId:number,value:any): Observable<Object> {
    return this.http.put(`${this.baseUrl3}/${centerId}`,value);
  }

  removeTest(testId : number):Observable<any>{
    return this.http.delete(`${this.baseUrl5}/${testId}`, { responseType: 'text' });
  }

  public addTest(centerId: number, test: Test){

    return this.http.post("http://localhost:8084/addTest/"+centerId,test);
  }

}

