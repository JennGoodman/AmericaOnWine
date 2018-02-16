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
    this.users = [];
    this.updateUserList();
  }

  ngOnInit() {
  }

  activateRetailer(retailer: User): void {
    this.adminService.activateRetailer(retailer).subscribe(resp => {
      const success = resp as boolean;
      const resultString = (success) ? 'success' : 'failure';
      console.log('Activating retailer was a ' + resultString);
      this.updateUserList();
    });
  }

  updateUserList(): void {
    console.log('Constructing');
    this.adminService.getPendingRetailerAccounts().subscribe(resp => {
      console.log('Constructed. Got: ');
      this.users = resp as User[];
      console.log(this.users);
    });
  }
}
