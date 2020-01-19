import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-late',
  templateUrl: './late.component.html',
  styleUrls: ['./late.component.css']
})
export class LateComponent implements OnInit {

  constructor() { }
  message;
  flag;

  lateComer: string[] = [
    'pavan',
    'siva',
    'anish',
    'akshay'
  ]


  person = 'khan';

  deleteLateComer(name: string) {
    this.lateComer.splice(this.lateComer.indexOf(name), 1);
    this.message = `${name} is deleted`;

    setTimeout(() => {
      this.message = null;
    }, 2000);
  }

  ngOnInit() {
  }

}
