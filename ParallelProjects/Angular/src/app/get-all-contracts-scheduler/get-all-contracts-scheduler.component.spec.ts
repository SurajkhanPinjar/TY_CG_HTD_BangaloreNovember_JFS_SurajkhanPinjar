import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllContractsSchedulerComponent } from './get-all-contracts-scheduler.component';

describe('GetAllContractsSchedulerComponent', () => {
  let component: GetAllContractsSchedulerComponent;
  let fixture: ComponentFixture<GetAllContractsSchedulerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllContractsSchedulerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllContractsSchedulerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
