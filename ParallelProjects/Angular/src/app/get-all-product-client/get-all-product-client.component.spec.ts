import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllProductClientComponent } from './get-all-product-client.component';

describe('GetAllProductClientComponent', () => {
  let component: GetAllProductClientComponent;
  let fixture: ComponentFixture<GetAllProductClientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllProductClientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllProductClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
