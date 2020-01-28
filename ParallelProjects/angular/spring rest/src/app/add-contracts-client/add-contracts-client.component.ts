import { Component, OnInit } from '@angular/core';
import { ContractsService } from '../contracts.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-contracts-client',
  templateUrl: './add-contracts-client.component.html',
  styleUrls: ['./add-contracts-client.component.css']
})
export class AddContractsClientComponent implements OnInit {

  success: string;
  failure: string;

  constructor(private contracts: ContractsService) { }

  addContacts(form: NgForm){
    this.contracts.addContracts(form.value).subscribe(data => {
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

  ngOnInit() {
  }

}
