import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { isNullOrUndefined } from 'util';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit() {
  }

  logout() {
    localStorage.removeItem('userDetails');
    this.router.navigateByUrl('/');
  }
  
  loggedIn() {
    if (!isNullOrUndefined(localStorage.getItem('userDetails'))) {
      return true;
    } else {
      return false;
    }
  }
}
