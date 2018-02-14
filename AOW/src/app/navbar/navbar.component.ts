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
    addEventListener('click', this.loadUser);
  }

  loadUser() {
    this.user = JSON.parse(localStorage.getItem('user'));
    console.log('Constructor Ran: ');
    console.log(this.user);
  }

  ngOnInit() {
  }

  logout() {
    this.service.logout().subscribe(resp => {
      const result = resp as string;
      localStorage.removeItem('user');
      this.user = null;
        this.router.navigate(['login']);
    });
  }
}
