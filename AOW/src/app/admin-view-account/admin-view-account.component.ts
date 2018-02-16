import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-admin-view-account',
  templateUrl: './admin-view-account.component.html',
  styleUrls: ['./admin-view-account.component.css']
})
export class AdminViewAccountComponent implements OnInit {

  users: User[];

  constructor(private adminService: AdminService) {
    console.log('Constructing');
    this.adminService.getPendingRetailerAccounts().subscribe(resp => {
      console.log('Constructed. Got: ');
      this.users = resp as User[];
      console.log(this.users);
    });
  }

  ngOnInit() {
  }

}
