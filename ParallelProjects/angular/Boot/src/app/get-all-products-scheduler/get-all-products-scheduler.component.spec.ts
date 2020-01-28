import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllProductsSchedulerComponent } from './get-all-products-scheduler.component';

describe('GetAllProductsSchedulerComponent', () => {
  let component: GetAllProductsSchedulerComponent;
  let fixture: ComponentFixture<GetAllProductsSchedulerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllProductsSchedulerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllProductsSchedulerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
