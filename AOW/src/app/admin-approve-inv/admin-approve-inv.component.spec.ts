import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminApproveInvComponent } from './admin-approve-inv.component';

describe('AdminApproveInvComponent', () => {
  let component: AdminApproveInvComponent;
  let fixture: ComponentFixture<AdminApproveInvComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminApproveInvComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminApproveInvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
