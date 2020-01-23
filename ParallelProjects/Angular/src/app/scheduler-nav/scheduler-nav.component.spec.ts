import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SchedulerNavComponent } from './scheduler-nav.component';

describe('SchedulerNavComponent', () => {
  let component: SchedulerNavComponent;
  let fixture: ComponentFixture<SchedulerNavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchedulerNavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SchedulerNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
