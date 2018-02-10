import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { User } from '../models/User';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {

  private aowUrl = 'http://example.com:8080/';
  private headers = new HttpHeaders();

  constructor(private http: HttpClient) {
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('enctype', 'multipart/form-data');
   }

  add(user: User): Observable<User> {
    const body = JSON.stringify(user);
    return this.http.post(this.aowUrl + 'user', body, { headers: this.headers, withCredentials: true })
      .map(
        resp => resp as User
      );
  }

  getAll(): Observable<User[]> {
    return this.http.get(this.aowUrl + 'user', { headers: this.headers, withCredentials: true })
      .map(
        resp => resp as User[]
      );
  }

  login(user: Object): Observable<User> {
    const body = JSON.stringify(user);
    return this.http.post(this.aowUrl + 'login', body, { headers: this.headers, withCredentials: true })
      .map(
        resp => resp as User
      );
  }

  update(user: User): Observable<User> {
    const body = JSON.stringify(user);
    return this.http.put(this.aowUrl + 'user', body, { headers: this.headers, withCredentials: true })
      .map(
        resp => resp as User
      );
  }
}
