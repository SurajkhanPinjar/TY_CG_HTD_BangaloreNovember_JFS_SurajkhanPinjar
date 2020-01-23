import { Component, OnInit } from '@angular/core';
import { LandService } from '../land.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-land',
  templateUrl: './add-land.component.html',
  styleUrls: ['./add-land.component.css']
})
export class AddLandComponent implements OnInit {

  success: string;
  failure: string;

  constructor( private land: LandService) { }

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
