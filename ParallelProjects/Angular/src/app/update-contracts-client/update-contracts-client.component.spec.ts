import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateContractsClientComponent } from './update-contracts-client.component';

describe('UpdateContractsClientComponent', () => {
  let component: UpdateContractsClientComponent;
  let fixture: ComponentFixture<UpdateContractsClientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateContractsClientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateContractsClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
