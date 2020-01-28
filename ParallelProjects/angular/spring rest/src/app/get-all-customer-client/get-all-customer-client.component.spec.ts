import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllCustomerClientComponent } from './get-all-customer-client.component';

describe('GetAllCustomerClientComponent', () => {
  let component: GetAllCustomerClientComponent;
  let fixture: ComponentFixture<GetAllCustomerClientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllCustomerClientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllCustomerClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
