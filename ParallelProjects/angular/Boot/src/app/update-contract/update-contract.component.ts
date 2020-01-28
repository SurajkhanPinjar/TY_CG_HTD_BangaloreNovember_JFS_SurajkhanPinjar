import { Component, OnInit } from '@angular/core';
import { ContractsService } from '../contracts.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-contract',
  templateUrl: './update-contract.component.html',
  styleUrls: ['./update-contract.component.css']
})
export class UpdateContractComponent implements OnInit {

                    contractNo1;
                    customerId1;
                    prodId1;
                    quantity1;
              
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
                                  });
                                }

  ngOnInit() { }

  updateContracts(form: NgForm) {
    console.log(form.value);
    this.contractDetails.updateContracts(form.value).subscribe( data => {
      console.log(data);
      this.router.navigateByUrl('/get-all-contracts');
    });
  }
}
