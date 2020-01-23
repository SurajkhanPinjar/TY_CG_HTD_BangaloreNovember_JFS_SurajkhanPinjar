import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContractsService {

  url = 'http://localhost:8080/forestrymanagementspringrest'

  constructor(private http: HttpClient) { }

  addContracts(contractDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/add-contracts`, contractDetails);
  }

  getAllContracts(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-all-contracts`);
  }

  deleteContracts(contracts: Contracts) {
    return this.http.delete<any>(`${this.url}/delete-contracts/${contracts.contractNo}`);
  }

  updateContracts(contracts) {
    return this.http.put<any>(`${this.url}/modify-contracts`, contracts);
  }

  scheduleContracts(contracts) {
    return this.http.put<any>(`${this.url}/schedule-contracts`, contracts);
  }
}
