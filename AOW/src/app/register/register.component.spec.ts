import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { User } from '../../models/User';
import { RegisterComponent } from './register.component';
import { AccountAccessService } from '../../services/account-access.service';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('register a new user, customer', () => {
    let ra = ''+Math.floor((Math.random()*1000)+1).toString;
    let ema = ra+'@gmail.com';
    component.register(ema, ra, ra, 'customer');
    let some: User = new User();
    some.id=5;
    some.username=ra;
    some.password=ra;
    some.email=ema;
    some.role=2;
    some.active=1;
    some.cancelled=0;

    expect(component.userRegistered.username).toBe(some.username);
    expect(component.userRegistered.email).toBe(some.email);
    expect(component.userRegistered.role).toBe(some.role);
    expect(component.userRegistered.active).toBe(some.active);
  });

  it('registering a new user, retailer', () => {
    let ra = ''+Math.floor((Math.random()*1000)+1).toString;
    let ema = ra+'@gmail.com';
    component.register(ema, ra, ra, 'retailer');
    let some: User = new User();
    some.id=5;
    some.username=ra;
    some.password=ra;
    some.email=ema;
    some.role=1;
    some.active=0;
    some.cancelled=0;

    expect(component.userRegistered.username).toBe(some.username);
    expect(component.userRegistered.email).toBe(some.email);
    expect(component.userRegistered.role).toBe(some.role);
    expect(component.userRegistered.active).toBe(some.active);
  });

  it('registering an existing user, customer', () => {
    component.register('customer@customer.net','customer','customer','customer');
    expect(component.userRegistered).toBe(null);
  });

  it('registering an existing user, retailer', () => {
    component.register('retailer@retailer.net','retailer','retailer','retailer');
    expect(component.userRegistered).toBe(null);
  });

  

});
