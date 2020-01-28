import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  url = 'http://localhost:8080'

  constructor(private http: HttpClient) { }

  registerUser(userDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/signup`, userDetails);
  }
  
  loginScheduler(schedulerDetails): Observable<any> {
    return this.http.post(`${this.url}/login-scheduler`, schedulerDetails);
  }

  loginUser(userDetails): Observable<any> {
    return this.http.post(`${this.url}/login-user`, userDetails);
  }

  loginClient(userDetails): Observable<any> {
    return this.http.post(`${this.url}/login-client`, userDetails);
  }

 

}
