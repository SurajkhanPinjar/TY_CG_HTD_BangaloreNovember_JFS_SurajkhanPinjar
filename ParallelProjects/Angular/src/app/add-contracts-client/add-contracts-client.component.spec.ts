import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddContractsClientComponent } from './add-contracts-client.component';

describe('AddContractsClientComponent', () => {
  let component: AddContractsClientComponent;
  let fixture: ComponentFixture<AddContractsClientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddContractsClientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddContractsClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
