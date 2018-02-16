import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminViewAccountComponent } from './admin-view-account.component';

describe('AdminViewAccountComponent', () => {
  let component: AdminViewAccountComponent;
  let fixture: ComponentFixture<AdminViewAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminViewAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminViewAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
