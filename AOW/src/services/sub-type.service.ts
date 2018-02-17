import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';

import { Config } from '../aow.config';

import { SubType } from '../models/SubType';

@Injectable()
export class SubTypeService {

  private config = new Config();
  private MyURL = this.config.appURL + 'subtype';

  constructor(private http: HttpClient) { }

  add(user: SubType): Observable<SubType> {
    const body = JSON.stringify(user);
    return this.http.post(this.MyURL, body, {
      headers: this.config.defaultHeaders
    })
      .map(
      resp => resp as SubType
      );
  }

  getAll(): Observable<SubType[]> {
    return this.http.get(this.MyURL, {
      headers: this.config.defaultHeaders
    })
      .map(
      resp => resp as SubType[]
      );
  }

  update(user: SubType): Observable<SubType> {
    const body = JSON.stringify(user);
    return this.http.put(this.MyURL, body, {
      headers: this.config.defaultHeaders
    })
      .map(
      resp => resp as SubType
      );
  }
}
