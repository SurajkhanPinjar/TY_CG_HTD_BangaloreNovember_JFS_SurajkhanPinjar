import { Component, OnInit, Input, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  constructor() { }

  @Output() childEvent = new EventEmitter();

  @Input()
  dataFromParent;

  sendData(data) {
    this.childEvent.emit(data);
  }
  
  ngOnInit() {
  }

}
