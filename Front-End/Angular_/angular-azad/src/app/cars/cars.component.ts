import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {
selectedCar;
  constructor() { }
  cars = [
    {
      name: 'BMW',
      imgURl: 'https://cdn.pixabay.com/photo/2015/05/15/14/46/bmw-768688_960_720.jpg',
      details: ''
    },{
      name: 'Audi',
      imgURl: 'https://cdn.pixabay.com/photo/2016/12/03/11/47/car-1879629_960_720.jpg',
      details: ''
    },{
      name: 'Jaguar',
      imgURl: 'https://cdn.pixabay.com/photo/2017/05/22/14/14/car-2334270_960_720.jpg',
      details: ''
    },{
      name: 'RR',
      imgURl: 'https://cdn.pixabay.com/photo/2019/08/18/17/59/rolls-royce-4414683_960_720.jpg',
      details: ''
    }
  ];

  selectCar(car) {
    this.selectedCar = car;
  }

  ngOnInit() {
  }

}
