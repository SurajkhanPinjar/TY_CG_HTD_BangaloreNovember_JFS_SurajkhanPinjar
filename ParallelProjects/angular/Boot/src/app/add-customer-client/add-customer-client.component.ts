import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-add-customer-client',
  templateUrl: './add-customer-client.component.html',
  styleUrls: ['./add-customer-client.component.css']
})
export class AddCustomerClientComponent implements OnInit {

  success: string;
  failure: string;

  constructor(private customer: CustomerService) { }

  ngOnInit() {
  }

  addCustomers(form: NgForm) {
    this.customer.addCustomers(form.value).subscribe(data => {
      console.log(data);

      if(data.statusCode === 201){
        this.success = data.description;
        setTimeout(() => {
          this.success = null;
        }, 2000);
        form.reset();
      } else {
        this.failure = data.description
        ;
        setTimeout(() => {
          this.failure = null;
        },2000);
      }
    });
  }

}
