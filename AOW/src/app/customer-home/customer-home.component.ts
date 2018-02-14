import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {
  user: User;

  constructor() {
    this.user = JSON.parse(localStorage.getItem('user'));
    this.user = new User;
    //this.user.username = 'bob';
   }

  ngOnInit() {
  }

}
