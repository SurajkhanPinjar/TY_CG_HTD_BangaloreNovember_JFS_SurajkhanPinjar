import { Component, OnInit } from '@angular/core';
import { LandService } from '../land.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-land',
  templateUrl: './get-all-land.component.html',
  styleUrls: ['./get-all-land.component.css']
})
export class GetAllLandComponent implements OnInit {
  success: string;
  failure: string;
  lands: Land[];

  constructor(private landDetails: LandService,
              private router : Router) {
                this.getAllLand();
   }

  ngOnInit() {
  }


  deleteLand(land: Land){
    this.landDetails.deleteLand(land).subscribe(data =>{
      console.log(data);
      if(data.statusCode === 201){
        this.lands.splice(this.lands.indexOf(land),1);
        this.success = data.message;
      }
    })
  }

  getAllLand() {
    this.landDetails.getAllLand().subscribe(response =>{
      console.log(response);
      if(response.statusCode === 201) {
        this.lands = response.landResponse;
        this.success = response.description;
        localStorage.setItem('Land Details', JSON.stringify(response));
        setTimeout(() => {
          this.success = null;
        }, 2000);
        
      } else {
        this.failure = response.description;
        localStorage.setItem('Land Details', JSON.stringify(response));
        console.log('Land Details are founded');
        setTimeout(() => {
          this.failure = null;
        }, 3000);
      }
    })
  }

  updateLand(land) {
    this.router.navigate([`update-land/${land.landId}`],
    { queryParams: { 
                    location: land.location,
                    value: land.value,
                    ownerName: land.ownerName,
                    date: land.date
                  }});
  }

}
