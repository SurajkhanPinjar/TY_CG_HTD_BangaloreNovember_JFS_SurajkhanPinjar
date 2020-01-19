import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  success: string;
  failure: string;
  constructor(private auth: AuthenticationService,private router: Router) { }

  ngOnInit() {
  }

  loginUser(form: NgForm) {
    this.auth.login(form.value).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.success = data.message;
        localStorage.setItem('userDetails', JSON.stringify(data));
        console.log('user Details Stored in local Storage');
        this.router.navigateByUrl('/');
        setTimeout(() => {
          this.success = null;
        }, 3000);
        form.reset();
      } else {
        this.failure = data.message;
        localStorage.setItem('userDetails', JSON.stringify(data));
        console.log('user Details Stored in local Storage');
        setTimeout(() => {
          this.failure = null;
        }, 3000);
      }
    });
  }

}
