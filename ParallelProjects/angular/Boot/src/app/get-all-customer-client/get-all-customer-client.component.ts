import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-customer-client',
  templateUrl: './get-all-customer-client.component.html',
  styleUrls: ['./get-all-customer-client.component.css']
})
export class GetAllCustomerClientComponent implements OnInit {
  success: string;
  failure: string;
  customers: Customer[];

  constructor(private customerDet: CustomerService,
              private router: Router) {
    this.getAllCustomer();
  }

  deleteCustomer(customer: Customer) {
    this.customerDet.deleteCustomer(customer).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.customers.splice(this.customers.indexOf(customer), 1);
        this.success = data.message;
        setTimeout(() => {
          this.success = null;
        }, 2000);
      }
    })
  }


  getAllCustomer() {
    this.customerDet.getAllCustomer().subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.customers = response.customerResponse;
        this.success = response.description;
        localStorage.setItem('customer Details', JSON.stringify(response));
        setTimeout(() => {
          this.success = null;
        }, 2000);

      } else {
        this.failure = response.description;
        localStorage.setItem('customer Details', JSON.stringify(response));
        console.log('Customer Details are Added');
        setTimeout(() => {
          this.failure = null;
        }, 2000);
      }
    })
  }

  ngOnInit() {
  }

  updateCustomer(customer) {
    this.router.navigate([`update-customer-client/${customer.customerId}`],
      {
        queryParams: {
          customerId: customer.customerId,
          customerName: customer.customerName,
          streetAdd1: customer.streetAdd1,
          streetAdd2: customer.streetAdd2,
          town: customer.town,
          postalCode: customer.postalCode,
          telephone: customer.telephone,
          email: customer.email

        }
      });
  }

}
