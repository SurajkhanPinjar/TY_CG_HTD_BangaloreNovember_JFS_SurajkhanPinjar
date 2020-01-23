import { Component, OnInit } from '@angular/core';
import { ContractsService } from '../contracts.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-schedule-contracts',
  templateUrl: './schedule-contracts.component.html',
  styleUrls: ['./schedule-contracts.component.css']
})
export class ScheduleContractsComponent implements OnInit {

  contractNo1;
  customerId1;
  prodId1;
  quantity1;
  deliveryDate1;
  status1;

  constructor(private contractDetails: ContractsService,
              private router: Router,
              activatedRoute: ActivatedRoute) {
                activatedRoute.params.subscribe( data => {
                  console.log(data.contractNo);
                  this.contractNo1 = data.contractNo;
                });
                activatedRoute.queryParams.subscribe( data => {
                  console.log(data);
                  this.customerId1 = data.customerId;
                  this.prodId1 = data.prodId;
                  this.quantity1 = data.quantity;
                  this.deliveryDate1 = data.deliveryDate;
                  this.status1 =  data.status;
                });
              }

  ngOnInit() {
  }

  scheduleContracts(form: NgForm) {
    console.log(form.value);
    this.contractDetails.scheduleContracts(form.value).subscribe( data => {
      console.log(data);
      this.router.navigateByUrl('/get-all-contracts-scheduler');
    });
  }

}
