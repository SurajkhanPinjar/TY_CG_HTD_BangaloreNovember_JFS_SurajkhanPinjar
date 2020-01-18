import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
 
  url = 'https://jsonplaceholder.typicode.com/posts';

  constructor(private http: HttpClient) { }


  getAllUser1(): Observable<any> {
    return this.http.get<any>(`${this.url}`);
  }

  addUser(user) : Observable<any> {
    return this.http.post<any>(`${this.url}`,user);
  }



}
