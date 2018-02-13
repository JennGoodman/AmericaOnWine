import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';

import { Config } from '../aow.config';
import { User } from '../models/User';


@Injectable()
export class AccountAccessService {

  private config = new Config();
  private MyURL = this.config.appURL + 'user';
  constructor(private http: HttpClient) { }

  login(user: User): Observable<User> {
    const body = JSON.stringify(user);
    return this.http.post(this.config.appURL + 'login', body, {
      headers: this.config.defaultHeaders, withCredentials: true
    }).map(
      resp => resp as User
    );
  }

  logout(): Observable<boolean> {
    return this.http.get(this.config.appURL + 'logout', {
      headers: this.config.defaultHeaders, withCredentials: true
    }).map(
      resp => resp as boolean
    );
  }

  register(user: User): Observable<User> {
    const body = JSON.stringify(user);
    return this.http.post(this.config.appURL + 'register', body, {
      headers: this.config.defaultHeaders, withCredentials: true
    }).map(
      resp => resp as User
    );
  }
}
