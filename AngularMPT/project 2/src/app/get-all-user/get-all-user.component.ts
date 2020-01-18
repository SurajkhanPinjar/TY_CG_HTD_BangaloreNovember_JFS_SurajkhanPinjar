import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-user',
  templateUrl: './get-all-user.component.html',
  styleUrls: ['./get-all-user.component.css']
})
export class GetAllUserComponent implements OnInit {

  success: string;
  failure: string;
  users: User[];

  constructor(private userDetails: UserService,
    private router: Router) {
    this.getAllUser();
  }

  ngOnInit() {
  }

  getAllUser() {
    this.userDetails.getAllUser1().subscribe(response => {
      console.log(response);
      // this.users = response.Array;
     

     
    })
  }

}
