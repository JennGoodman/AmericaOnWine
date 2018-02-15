import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';

import { Config } from '../aow.config';

import { Inventory } from '../models/Inventory';

@Injectable()
export class InventoryService {

  private config = new Config();
  private MyURL = this.config.appURL + 'inventory';

  constructor(private http: HttpClient) { }

  add(user: Inventory): Observable<Inventory> {
    console.log('add in inventory.service called');
    const body = JSON.stringify(user);
    console.log('body is ' + body);
    console.log(JSON.stringify(user.brand));
    return this.http.post(this.MyURL, body, {
      headers: this.config.defaultHeaders, withCredentials: true
    })
      .map(
      resp => resp as Inventory
      );
  }

  getAll(): Observable<Inventory[]> {
    return this.http.get(this.MyURL, {
      headers: this.config.defaultHeaders, withCredentials: true
    })
      .map(
      resp => resp as Inventory[]
      );
  }

  update(user: Inventory): Observable<Inventory> {
    const body = JSON.stringify(user);
    return this.http.put(this.MyURL, body, {
      headers: this.config.defaultHeaders, withCredentials: true
    })
      .map(
      resp => resp as Inventory
      );
  }
}
