import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RetailItemViewComponent } from './retail-item-view.component';

describe('RetailItemViewComponent', () => {
  let component: RetailItemViewComponent;
  let fixture: ComponentFixture<RetailItemViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RetailItemViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RetailItemViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
