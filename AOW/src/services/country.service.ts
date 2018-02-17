import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';

import { Config } from '../aow.config';

import { Country } from '../models/Country';

@Injectable()
export class CountryService {

  private config = new Config();
  private MyURL = this.config.appURL + 'country';

  constructor(private http: HttpClient) { }

  add(user: Country): Observable<Country> {
    const body = JSON.stringify(user);
    return this.http.post(this.MyURL, body, {
      headers: this.config.defaultHeaders
    })
      .map(
      resp => resp as Country
      );
  }

  getAll(): Observable<Country[]> {
    return this.http.get(this.MyURL, {
      headers: this.config.defaultHeaders
    })
      .map(
      resp => resp as Country[]
      );
  }

  update(user: Country): Observable<Country> {
    const body = JSON.stringify(user);
    return this.http.put(this.MyURL, body, {
      headers: this.config.defaultHeaders
    })
      .map(
      resp => resp as Country
      );
  }
}
