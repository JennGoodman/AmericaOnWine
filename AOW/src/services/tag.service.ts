import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';

import { Config } from '../aow.config';

import { Tag } from '../models/Tag';

@Injectable()
export class TagService {

  private config = new Config();
  private MyURL = this.config.appURL + 'tag';

  constructor(private http: HttpClient) { }

  add(user: Tag): Observable<Tag> {
    const body = JSON.stringify(user);
    return this.http.post(this.MyURL, body, {
      headers: this.config.defaultHeaders, withCredentials: true
    })
      .map(
      resp => resp as Tag
      );
  }

  getAll(): Observable<Tag[]> {
    return this.http.get(this.MyURL, {
      headers: this.config.defaultHeaders, withCredentials: true
    })
      .map(
      resp => resp as Tag[]
      );
  }

  update(user: Tag): Observable<Tag> {
    const body = JSON.stringify(user);
    return this.http.put(this.MyURL, body, {
      headers: this.config.defaultHeaders, withCredentials: true
    })
      .map(
      resp => resp as Tag
      );
  }
}
