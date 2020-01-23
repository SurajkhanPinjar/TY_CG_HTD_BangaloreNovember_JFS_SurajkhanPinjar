import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  customerId1;
  customerName1;
  streetAdd01;
  streetAdd02;
  town1;
  postalCode1;
  telephone1;
  email1;


  constructor(private customerDetails: CustomerService,
              private router: Router,
              activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(data => {
      console.log(data.customerId);
      this.customerId1 = data.customerId;
    });
    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      this.customerName1 = data.customerName;
      this.streetAdd01 = data.streetAdd1;
      this.streetAdd02 = data.streetAdd2;
      this.town1 = data.town;
      this.postalCode1 = data.postalCode;
      this.telephone1 = data.telephone;
      this.email1 = data.email;
    });
  }

  ngOnInit() {
  }

  update(form: NgForm) {
    console.log(form.value);
    this.customerDetails.update(form.value).subscribe(data => {
      console.log(data);
      this.router.navigateByUrl('/get-all-customer');
    });
  }

}
