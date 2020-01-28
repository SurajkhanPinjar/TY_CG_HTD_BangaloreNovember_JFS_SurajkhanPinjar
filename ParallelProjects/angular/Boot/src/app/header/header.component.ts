import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { isNullOrUndefined } from 'util';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }

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

isClient() {
  if (!isNullOrUndefined(localStorage.getItem('userDetails'))) {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails.role === 'client') {
      return true;
    } else {
      return false;
    }
  } else {
    return false;
  }
}

isScheduler() {
  if (!isNullOrUndefined(localStorage.getItem('userDetails'))) {
    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails.role === 'scheduler') {
      return true;
    } else {
      return false;
    }
  } else {
    return false;
  }
}

}
