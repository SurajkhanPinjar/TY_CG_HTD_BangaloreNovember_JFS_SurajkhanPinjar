import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCustomerClientComponent } from './update-customer-client.component';

describe('UpdateCustomerClientComponent', () => {
  let component: UpdateCustomerClientComponent;
  let fixture: ComponentFixture<UpdateCustomerClientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateCustomerClientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCustomerClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
