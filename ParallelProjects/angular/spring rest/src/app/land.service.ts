import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LandService {

  url = 'http://localhost:8080/forestrymanagementspringrest';

  constructor(private http: HttpClient) { }

  addLand(landDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/add-land`, landDetails);
  } 
  
  getAllLand(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-all-land`);
  }

  deleteLand(land: Land) {
    return this.http.delete<any>(`${this.url}/delete-land/${land.landId}`);
  }
  
  updateLand(land) {
    return this.http.put<any>(`${this.url}/modify-Land`, land);
  }
}
