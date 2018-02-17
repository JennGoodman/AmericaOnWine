import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';

import { Config } from '../aow.config';

import { Type } from '../models/Type';

@Injectable()
export class TypeService {

  private config = new Config();
  private MyURL = this.config.appURL + 'type';

  constructor(private http: HttpClient) { }

  add(user: Type): Observable<Type> {
    const body = JSON.stringify(user);
    return this.http.post(this.MyURL, body, {
      headers: this.config.defaultHeaders
    })
      .map(
      resp => resp as Type
      );
  }

  getAll(): Observable<Type[]> {
    return this.http.get(this.MyURL, {
      headers: this.config.defaultHeaders
    })
      .map(
      resp => resp as Type[]
      );
  }

  update(user: Type): Observable<Type> {
    const body = JSON.stringify(user);
    return this.http.put(this.MyURL, body, {
      headers: this.config.defaultHeaders
    })
      .map(
      resp => resp as Type
      );
  }
}
