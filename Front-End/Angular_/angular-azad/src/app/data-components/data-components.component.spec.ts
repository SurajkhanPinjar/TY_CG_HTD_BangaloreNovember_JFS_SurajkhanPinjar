import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataComponentsComponent } from './data-components.component';

describe('DataComponentsComponent', () => {
  let component: DataComponentsComponent;
  let fixture: ComponentFixture<DataComponentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataComponentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataComponentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
