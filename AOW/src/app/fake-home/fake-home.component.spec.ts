import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FakeHomeComponent } from './fake-home.component';

describe('FakeHomeComponent', () => {
  let component: FakeHomeComponent;
  let fixture: ComponentFixture<FakeHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FakeHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FakeHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
