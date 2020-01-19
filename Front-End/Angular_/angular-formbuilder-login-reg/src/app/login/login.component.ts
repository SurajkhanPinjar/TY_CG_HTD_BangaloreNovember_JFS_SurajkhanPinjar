import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // dateObject = new Date();

  // date = this.dateObject.getDate();
  // month = this.dateObject.getMonth();
  // year = this.dateObject.getFullYear();

  // todaysDate = `${this.year}-$`

  todaysDate = Date.now();
  constructor() { }

  submitForm(form: NgForm) {
    console.log(form);
    form.reset();         //Reset The Values After Login         
  }

  ngOnInit() {
  }

}
