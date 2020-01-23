import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountsService {
  
  url = 'http://localhost:8080/forestrymanagementspringrest'

  constructor(private http: HttpClient) { }

  registerAccount(userDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/add-scheduler`, userDetails);
  }
}
