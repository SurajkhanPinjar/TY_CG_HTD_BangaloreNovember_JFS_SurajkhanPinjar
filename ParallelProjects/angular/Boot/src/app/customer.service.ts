import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  url = 'http://localhost:8080';
  
  constructor(private http: HttpClient) { }

  addCustomers(customerDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/add-customer`, customerDetails);
  } 

  searchCustomer(customerDetails): Observable<any> {
    return this.http.get<any>(`${this.url}/get-customer`, customerDetails);
  }

  getAllCustomer(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-all-customer`);
  }

  deleteCustomer(customer: Customer) {
    return this.http.delete<any>(`${this.url}/delete-customer/${customer.customerId}`);
  }

  update(customer) {
    return this.http.put<any>(`${this.url}/modify-customer`, customer);
  }

}
