import { HttpHeaders } from '@angular/common/http';

export class Config {
    appURL: string;
    defaultHeaders: HttpHeaders;

    constructor() {
<<<<<<< HEAD
        // this.appURL = 'http://localhost:8081/AmericaOnWine/';
=======
        // this.appURL = 'http://localhost:8080/AmericaOnWine/';
>>>>>>> 7c82da57c2fadac24be3fd8760464d9d8881f80e
        this.appURL = 'http://18.219.46.59:8080/americaonwine/';
        this.defaultHeaders = new HttpHeaders();
        this.defaultHeaders = this.defaultHeaders.append('Content-Type', 'application/json');
        // this.defaultHeaders = this.defaultHeaders.append('Access-Control-Allow-Origin', '*');
        // this.defaultHeaders = this.defaultHeaders.append('Accept', 'application/json');
        // this.defaultHeaders.append('enctype', 'multipart/form-data');

        // console.log('In the constructor, Headers are ');
        // console.log(this.defaultHeaders);
    }
  }
