import { Component, OnInit } from '@angular/core';
import { ContractsService } from '../contracts.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-contracts-scheduler',
  templateUrl: './get-all-contracts-scheduler.component.html',
  styleUrls: ['./get-all-contracts-scheduler.component.css']
})
export class GetAllContractsSchedulerComponent implements OnInit {

  success: string;
  failure: string;
  contracts: Contracts[];
  constructor(private contractsDet: ContractsService,
              private router: Router) { 
                this.getAllContracts();
              }

  ngOnInit() {
  }

  getAllContracts() {
    this.contractsDet.getAllContracts().subscribe(response =>{
      console.log(response);
      if(response.statusCode === 201) {
        this.contracts = response.contractsResponse;
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
        }, 3000);
      }
    })
  }

  scheduleContracts(contract) {
    this.router.navigate([`schedule-contract/${contract.contractNo}`],
    { queryParams: { 
                    customerId: contract.customerId,
                    prodId: contract.prodId,
                    quantity: contract.quantity,
                    deliveryDate: contract.deliveryDate,
                    status: contract.status
                    }});
  }

}
