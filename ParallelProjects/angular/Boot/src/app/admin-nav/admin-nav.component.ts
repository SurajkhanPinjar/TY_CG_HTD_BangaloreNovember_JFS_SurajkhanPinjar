import { Component, OnInit } from '@angular/core';
import { isNullOrUndefined } from 'util';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-nav',
  templateUrl: './admin-nav.component.html',
  styleUrls: ['./admin-nav.component.css']
})
export class AdminNavComponent implements OnInit {

  constructor(private router: Router) { }


  ngOnInit() {
  }

  isAdmin() {
    if (!isNullOrUndefined(localStorage.getItem('userDetails'))) {
      const userDetails = JSON.parse(localStorage.getItem('userDetails'));
      if (userDetails.role === 'admin') {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

}
