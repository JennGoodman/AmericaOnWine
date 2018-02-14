import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  user: User;

  constructor() {
    this.user = JSON.parse(localStorage.getItem('user'));
    // this.user = new User;
    // this.user.username = 'bob';
   }

  ngOnInit() {
  }

}
