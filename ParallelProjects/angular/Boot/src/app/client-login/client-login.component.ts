import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-client-login',
  templateUrl: './client-login.component.html',
  styleUrls: ['./client-login.component.css']
})
export class ClientLoginComponent implements OnInit {

  success: string;
  failure: string;

  constructor(private auth: AuthenticationService,
              private router: Router) { }

              loginClient(form: NgForm) {
                this.auth.loginClient(form.value).subscribe(data => {
                  console.log(data);
                  if (data.statusCode === 201) {
                    this.success = data.description;
                    localStorage.setItem('userDetails', JSON.stringify(data.clientResponse['0']));
                    console.log(JSON.stringify(data.clientResponse['0']));
                    console.log('user Details Stored in local Storage');
                    this.router.navigateByUrl('/client');
                    setTimeout(() => {
                      this.success = null;
                    }, 3000);
                    form.reset();
                  } else {
                    this.failure = data.description;
                    localStorage.setItem('userDetails', JSON.stringify(data));
                    console.log('user Details Stored in local Storage');
                    setTimeout(() => {
                      this.failure = null;
                    }, 3000);
                  }
                });
              }

  ngOnInit() {
  }

}
