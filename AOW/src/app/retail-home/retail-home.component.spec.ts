import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RetailHomeComponent } from './retail-home.component';

describe('RetailHomeComponent', () => {
  let component: RetailHomeComponent;
  let fixture: ComponentFixture<RetailHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RetailHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RetailHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
