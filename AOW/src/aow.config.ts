import { HttpHeaders } from '@angular/common/http';

export class Config {
    appURL: string;
    defaultHeaders: HttpHeaders;

    constructor() {
        this.appURL = 'http://18.217.53.157:8080/americaonwine/';
        this.defaultHeaders = new HttpHeaders();
        this.defaultHeaders.append('Content-Type', 'application/json');
        //this.defaultHeaders.append('enctype', 'multipart/form-data');
    }
  }
