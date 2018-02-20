import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RetailAlertsComponent } from './retail-alerts.component';

describe('RetailAlertsComponent', () => {
  let component: RetailAlertsComponent;
  let fixture: ComponentFixture<RetailAlertsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RetailAlertsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RetailAlertsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
