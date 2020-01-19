import { Component, OnInit, OnDestroy, DoCheck, AfterContentInit, AfterContentChecked } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
}) 
export class ParentComponent implements OnInit, OnDestroy, DoCheck, AfterContentInit, AfterContentChecked {

  constructor() { }
  dataFromChild;

  student = {
    name: 'khan',
    age: 23,
    marks: 70

  };
  //To get Data From child Component
  getChildData(data) {
    this.dataFromChild = data;
  }
  ngOnInit() {
    console.log('on init executed');
  }

  ngOnDestroy() {
    console.log('on Destroy Executed');
  }

  ngDoCheck() {
    console.log('do check Executed');

  }

  ngAfterContentInit() {
    console.log('After Content Init Executed');
  }

  ngAfterContentChecked() {
    console.log('After Content Executed');
  }

}
