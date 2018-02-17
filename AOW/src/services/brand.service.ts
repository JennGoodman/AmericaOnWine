import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';

import { Config } from '../aow.config';

import { Brand } from '../models/Brand';

@Injectable()
export class BrandService {

  private config = new Config();
  private MyURL = this.config.appURL + 'brand';

  constructor(private http: HttpClient) { }

  add(user: Brand): Observable<Brand> {
    const body = JSON.stringify(user);
    return this.http.post(this.MyURL, body, {
      headers: this.config.defaultHeaders, withCredentials: true
    })
      .map(
      resp => resp as Brand
      );
  }

  getAll(): Observable<Brand[]> {
    return this.http.get(this.MyURL, {
      headers: this.config.defaultHeaders, withCredentials: true
    })
      .map(
      resp => resp as Brand[]
      );
  }

  update(user: Brand): Observable<Brand> {
    const body = JSON.stringify(user);
    return this.http.put(this.MyURL, body, {
      headers: this.config.defaultHeaders, withCredentials: true
    })
      .map(
      resp => resp as Brand
      );
  }
}
