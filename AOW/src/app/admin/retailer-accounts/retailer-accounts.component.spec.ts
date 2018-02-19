import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RetailerAccountsComponent } from './retailer-accounts.component';

describe('RetailerAccountsComponent', () => {
  let component: RetailerAccountsComponent;
  let fixture: ComponentFixture<RetailerAccountsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RetailerAccountsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RetailerAccountsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
