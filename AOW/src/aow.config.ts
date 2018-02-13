import { HttpHeaders } from '@angular/common/http';

export class Config {
    appURL: string;
    defaultHeaders: HttpHeaders;

    constructor() {
        this.appURL = 'http://18.219.46.59:8080/americaonwine/';
        this.defaultHeaders = new HttpHeaders();
        this.defaultHeaders.append('Content-Type', 'application/json');
        this.defaultHeaders.append('Access-Control-Allow-Origin', '*');
        //this.defaultHeaders.append('enctype', 'multipart/form-data');
    }
  }
