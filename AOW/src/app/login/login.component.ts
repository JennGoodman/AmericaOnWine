import { Component, OnInit } from '@angular/core';

import { User } from '../../models/User';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountAccessService } from '../../services/account-access.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginFailed: boolean;
  loggedInUser: User;
  constructor(private service: AccountAccessService, private router: Router) {
    this.loginFailed = false;
  }

  ngOnInit() {
  }

  login(username: string, password: string) {
    console.log(username + ' ' + password);
    this.loginFailed = false;
    const user: User = new User();
    user.username = username;
    user.password = password;
    console.log(JSON.stringify(user));

    this.service.login(user).subscribe(resp => {
      this.loggedInUser = resp as User;
      if (this.loggedInUser == null) {
        this.loginFailed = true;
        localStorage.setItem('user', JSON.stringify(this.loggedInUser));
      } else {
        // Redirect to home
        this.router.navigate(['']);
      }
    });
  }

  register() {
    // redirect to registration page
    this.router.navigate(['register']);
  }
}
