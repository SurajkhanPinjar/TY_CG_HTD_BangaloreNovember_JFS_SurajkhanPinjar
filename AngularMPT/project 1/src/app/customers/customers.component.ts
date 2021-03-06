import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  customers: Customer[];

  constructor(private http: HttpClient) {
    this.getCustomer();
  }

  getCustomer() {
    this.http.get<Customer[]>('../../assets/customer.json').subscribe(resp => {
      console.log(resp);
      this.customers = resp;
    });
  }

  ngOnInit() {
  }

}

interface Customer {
  name: string,
  email: string,
  phone: number
}

