import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RateShowComponent } from './rate-show.component';

describe('RateShowComponent', () => {
  let component: RateShowComponent;
  let fixture: ComponentFixture<RateShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RateShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RateShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
