import { Injectable } from '@angular/core';
import { Config } from '../aow.config';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../models/User';

@Injectable()
export class AdminService {

  private config = new Config();

  constructor(private http: HttpClient) { }

  getPendingRetailerAccounts(): Observable<User[]> {
    return this.http.get(this.config.appURL + 'pendingAccounts', {
      headers: this.config.defaultHeaders, withCredentials: true
    }).map(
      resp => resp as User[]
    );
  }

  activateRetailer(retailer: User): Observable<boolean> {
    const body = JSON.stringify(retailer);
    return this.http.post(this.config.appURL + 'activateRetailer', body, {
      headers: this.config.defaultHeaders, withCredentials: true
    }).map(
      resp => resp as boolean
    );
  }

  getAllRetailers(): Observable<User[]> {
    return this.http.get(this.config.appURL + 'retailerAccounts', {
      headers: this.config.defaultHeaders, withCredentials: true
    }).map(
      resp => resp as User[]
    );
  }

  cancelRetailer(retailer: User): Observable<boolean> {
    const body = JSON.stringify(retailer);
    return this.http.post(this.config.appURL + 'cancelRetailer', body, {
      headers: this.config.defaultHeaders, withCredentials: true
    }).map(
      resp => resp as boolean
    );
  }

  reactivateRetailer(retailer: User): Observable<boolean> {
    const body = JSON.stringify(retailer);
    return this.http.post(this.config.appURL + 'reactivateRetailer', body, {
      headers: this.config.defaultHeaders, withCredentials: true
    }).map(
      resp => resp as boolean
    );
  }
}
