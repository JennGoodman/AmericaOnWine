import { Component, OnInit } from '@angular/core';

import { User } from '../../models/User';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountAccessService } from '../../services/account-access.service';
import { Transaction } from '../../models/Transaction';

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
        localStorage.setItem('user', JSON.stringify(this.loggedInUser));

        const cart = <Transaction[]> JSON.parse(localStorage.getItem('cart')) ? JSON.parse(localStorage.getItem('cart')) : [];
        cart.forEach((item) => {
          item.userId = this.loggedInUser.id;
        });
        localStorage.setItem('cart', JSON.stringify(cart));
        if (this.loggedInUser.role === 0) {
          this.router.navigate(['admin/home']);
        } else if (this.loggedInUser.role === 1) {
          this.router.navigate(['']);
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
