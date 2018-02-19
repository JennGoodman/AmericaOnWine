import { Component, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-fake-home',
  templateUrl: './fake-home.component.html',
  styleUrls: ['./fake-home.component.css']
})
export class FakeHomeComponent implements OnInit {

  isCustomer: boolean;
  @Output() home = false;
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
      return '80%';
    } else {
      return '100%';
    }
  }

}
