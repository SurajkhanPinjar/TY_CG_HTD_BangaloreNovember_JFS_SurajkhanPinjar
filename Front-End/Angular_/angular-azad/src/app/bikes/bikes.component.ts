import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bikes',
  templateUrl: './bikes.component.html',
  styleUrls: ['./bikes.component.css']
})
export class BikesComponent implements OnInit {
  selectedBike;
  constructor() { }

  bikes = [
    {
      name: 'BMW',
      imgURl: 'https://cdn.pixabay.com/photo/2016/04/07/06/53/bmw-1313343__340.jpg',
      details: ''
    },{
      name: 'RoyalEnfield',
      imgURl: 'https://cdn.pixabay.com/photo/2017/11/23/04/08/royal-enfield-2972007__340.jpg',
      details: ''
    },{
      name: 'Apache',
      imgURl: 'https://cdn.pixabay.com/photo/2017/12/29/05/58/sport-3046819__340.jpg',
      details: ''
    },{
      name: 'HarleyDavidSon',
      imgURl: 'https://cdn.pixabay.com/photo/2015/04/10/15/27/harley-716352__340.jpg',
      details: ''
    }
  ];

  selectBike(bike) {
    this.selectedBike = bike;
  }
  ngOnInit() {
  }

}
