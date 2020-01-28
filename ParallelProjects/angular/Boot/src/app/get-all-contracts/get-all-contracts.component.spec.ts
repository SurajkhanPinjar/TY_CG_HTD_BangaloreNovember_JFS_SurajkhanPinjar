import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllContractsComponent } from './get-all-contracts.component';

describe('GetAllContractsComponent', () => {
  let component: GetAllContractsComponent;
  let fixture: ComponentFixture<GetAllContractsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllContractsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllContractsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
