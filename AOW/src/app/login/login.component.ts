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
      } else {
        // Redirect to home
        localStorage.setItem('user', JSON.stringify(this.loggedInUser));
        if (this.loggedInUser.role === 0) {
          this.router.navigate(['admin/home']);
        } else if (this.loggedInUser.role === 1) {
          this.router.navigate(['items']);
        } else {
          this.router.navigate(['']);
        }
        location.reload();
      }
    });
  }

  register() {
    // redirect to registration page
    this.router.navigate(['register']);
  }
}
