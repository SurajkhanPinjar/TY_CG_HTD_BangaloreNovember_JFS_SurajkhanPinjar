import { Component, OnInit } from '@angular/core';
import { LandService } from '../land.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-land',
  templateUrl: './add-land.component.html',
  styleUrls: ['./add-land.component.css']
})
export class AddLandComponent implements OnInit {

  success: string;
  failure: string;
  today: string;

  constructor( private land: LandService, 
               private router: Router) { 
                  let todayDate = new Date();
                  let date = todayDate.getDate();
                  let year = todayDate.getFullYear();
                  let month = todayDate.getMonth() + 1;
                  if (todayDate.getMonth() > 8) {
                    this.today = year + '-' + month + '-' + date;
                  } else {
                    this.today = year + '-' + '0' + month + '-' + date;
                  }

               }

  ngOnInit() {
  }

  addLand(form: NgForm) {
    this.land.addLand(form.value).subscribe(data => {
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


}
