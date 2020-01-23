import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-search-customer',
  templateUrl: './search-customer.component.html',
  styleUrls: ['./search-customer.component.css']
})
export class SearchCustomerComponent implements OnInit {

  success: string;
  failure: string;
  customers: Customer[];
 
  constructor(private customerDetails : CustomerService,
              private router: Router) {
                

               }

  ngOnInit() {
  }

  searchCustomer(form: NgForm) {
    this.customerDetails.searchCustomer(form.value).subscribe(response => {
      console.log(response);
    
      if(response.statusCode === 201) {
        this.customers = response.customerResponse;
        this.success = response.description;
        localStorage.setItem('customer Details', JSON.stringify(response));
        
        
      } else {
        this.failure = response.description;
        localStorage.setItem('customer Details', JSON.stringify(response));
        console.log('Customer Details are Added');
        setTimeout(() => {
          this.failure = null;
        }, 3000);
      }
    })
  }


}
