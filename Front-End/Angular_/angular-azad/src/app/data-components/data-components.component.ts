import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-components',
  templateUrl: './data-components.component.html',
  styleUrls: ['./data-components.component.css']
})
export class DataComponentsComponent implements OnInit {
    flag = true;
    twoWayData;
    imgUrl = "https://cdn.pixabay.com/photo/2015/01/18/19/42/cambodia-603401__340.jpg";
  
    constructor() {
    // setInterval(() => {
    //   this.flag = !this.flag;
    // },2000)
   }

   clickMe(input) {
     console.log(input);
     console.log(input.value);
    this.flag = !this.flag;
   }

   //Two way Data
   printData() {
     console.log(this.twoWayData);
   }

  ngOnInit() {
  }

}
