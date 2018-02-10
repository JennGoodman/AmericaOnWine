import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';

import { Transaction } from '../models/Transaction';

@Injectable()
export class TransactionService {

  private aowUrl = 'http://example.com:8080/';
  private headers = new HttpHeaders();

  constructor(private http: HttpClient) {
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('enctype', 'multipart/form-data');
  }

  add(user: Transaction): Observable<Transaction> {
    const body = JSON.stringify(user);
    return this.http.post(this.aowUrl + 'transaction', body, { headers: this.headers, withCredentials: true })
      .map(
      resp => resp as Transaction
      );
  }

  getAll(): Observable<Transaction[]> {
    return this.http.get(this.aowUrl + 'transaction', { headers: this.headers, withCredentials: true })
      .map(
      resp => resp as Transaction[]
      );
  }

  update(user: Transaction): Observable<Transaction> {
    const body = JSON.stringify(user);
    return this.http.put(this.aowUrl + 'transaction', body, { headers: this.headers, withCredentials: true })
      .map(
      resp => resp as Transaction
      );
  }
}
