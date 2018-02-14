import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BigWineItemComponent } from './big-wine-item.component';

describe('BigWineItemComponent', () => {
  let component: BigWineItemComponent;
  let fixture: ComponentFixture<BigWineItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BigWineItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BigWineItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
