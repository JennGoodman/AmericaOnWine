import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isCustomer: boolean;
  constructor() {
    if (localStorage.getItem('user') != null) {
      this.isCustomer = JSON.parse(localStorage.getItem('user')).role === 2;
    } else {
      this.isCustomer = true;
    }
  }

  ngOnInit() {
  }

  getWidth() {
    if (this.isCustomer) {
      return '85%';
    } else {
      return '100%';
    }
  }

}
