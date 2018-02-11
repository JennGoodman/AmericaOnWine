import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginFailed: boolean;
  constructor() {
    this.loginFailed = false;
  }

  ngOnInit() {
  }

  login(username: string, password: string) {
    // TODO
  }

  register() {
    // TODO
  }
}
