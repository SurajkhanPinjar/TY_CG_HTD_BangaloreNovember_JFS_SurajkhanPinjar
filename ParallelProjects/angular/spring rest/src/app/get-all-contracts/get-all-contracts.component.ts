import { Component, OnInit } from '@angular/core';
import { ContractsService } from '../contracts.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-contracts',
  templateUrl: './get-all-contracts.component.html',
  styleUrls: ['./get-all-contracts.component.css']
})
export class GetAllContractsComponent implements OnInit {


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

  deleteContracts(contracts: Contracts) {
    this.contractsDet.deleteContracts(contracts).subscribe(data =>{
      console.log(data);
      if(data.statusCode === 201){
        this.contracts.splice(this.contracts.indexOf(contracts),1);
        this.success = data.message;
      }
    })
  }

  updateContracts(contract) {
    this.router.navigate([`update-contract/${contract.contractNo}`],
    { queryParams: { 
                    customerId: contract.customerId,
                    prodId: contract.prodId,
                    quantity: contract.quantity,
                    }});
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
