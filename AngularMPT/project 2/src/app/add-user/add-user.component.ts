import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  
  success: string;
  failure: string;

  constructor(private userDetails: UserService,
              private http: HttpClient) { }

  ngOnInit() {
  }

  // addUser(form: NgForm) {
  //   // tslint:disable-next-line: deprecation
  //   this.userDetails.addUser(form.value).subscribe(data => {
  //     console.log(data);

  //   }
  // }
}
