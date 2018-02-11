import { Component, OnInit } from '@angular/core';

import { User } from '../../models/User';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginFailed: boolean;
  loggedInUser: User;
  constructor(private service: UserService, private router: Router) {
    this.loginFailed = false;
  }

  ngOnInit() {
  }

  login(username: string, password: string) {
    this.loginFailed = false;
    const user: User = new User();
    user.username = username;
    user.password = password;

    this.service.login(user).subscribe(resp => {
      this.loggedInUser = resp as User;
      if (this.loggedInUser == null) {
        this.loginFailed = true;
      } else {
        // Redirect to home
        this.router.navigate(['']);
      }
    });
  }

  register() {
    // redirect to registration page
    this.router.navigate(['']);
  }
}
