import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllContractsClientComponent } from './get-all-contracts-client.component';

describe('GetAllContractsClientComponent', () => {
  let component: GetAllContractsClientComponent;
  let fixture: ComponentFixture<GetAllContractsClientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllContractsClientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllContractsClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
