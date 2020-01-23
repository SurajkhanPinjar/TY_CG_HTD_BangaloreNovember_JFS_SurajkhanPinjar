import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllLandComponent } from './get-all-land.component';

describe('GetAllLandComponent', () => {
  let component: GetAllLandComponent;
  let fixture: ComponentFixture<GetAllLandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllLandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllLandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
