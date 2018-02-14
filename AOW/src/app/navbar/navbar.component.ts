import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { AccountAccessService } from '../../services/account-access.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  user: User;

  constructor(private service: AccountAccessService, private router: Router) {
    this.user = JSON.parse(localStorage.getItem('user'));
    // this.user = new User;
    // this.user.username = 'bob';
   }

  ngOnInit() {
  }

  logout() {
    this.service.logout().subscribe(resp => {
      const result = resp as string;
      localStorage.removeItem('user');
      this.router.navigate(['login']);
    });
  }
}
