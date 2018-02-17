import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingAccountComponent } from './pending-accts.component';

describe('PendingAccountComponent', () => {
  let component: PendingAccountComponent;
  let fixture: ComponentFixture<PendingAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
