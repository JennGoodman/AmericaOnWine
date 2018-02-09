import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions } from '@angular/http';

import { Observable } from 'rxjs/observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';

@Injectable()
export class ExampleService {
  private appUrl = 'http://example.com:8080/';
  private headers = new Headers({ 'Content-Type': 'application/json' });

  constructor(private http: Http) { }

  getExample(): Observable<Example[]> {
    return this.http.get(this.appUrl + 'example', { headers: this.headers, withCredentials: true })
      .map(
        resp => resp.json() as Example[]
      );
  }
}
