import { Component, OnInit } from '@angular/core';
import { LandService } from '../land.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-land',
  templateUrl: './update-land.component.html',
  styleUrls: ['./update-land.component.css']
})
export class UpdateLandComponent implements OnInit {

  landId1;
  location1;
  value1;
  ownerName1;
  date1;
  today;




  constructor(private landDetails: LandService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(data => {
      console.log(data.landId);
      this.landId1 = data.landId;
    });

    let todayDate = new Date();
    let date = todayDate.getDate();
    let year = todayDate.getFullYear();
    let month = todayDate.getMonth() + 1;
    if (todayDate.getMonth() > 8) {
      this.today = year + '-' + month + '-' + date;
    } else {
      this.today = year + '-' + '0' + month + '-' + date;
    }

    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      this.location1 = data.location;
      this.value1 = data.value;
      this.ownerName1 = data.ownerName;
      this.date1 = data.date;
    });
  }

  ngOnInit() {
  }

  updateLand(form: NgForm) {
    console.log(form.value);
    this.landDetails.updateLand(form.value).subscribe(data => {
      console.log(data);
      this.router.navigateByUrl('/get-all-land');
    });
  }

}
