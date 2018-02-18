import { Component, OnInit } from '@angular/core';
import { User } from '../../../models/User';
import { AdminService } from '../../../services/admin.service';

@Component({
  selector: 'app-retailer-accounts',
  templateUrl: './retailer-accounts.component.html',
  styleUrls: ['./retailer-accounts.component.css']
})
export class RetailerAccountsComponent implements OnInit {

  users: User[];
  constructor(private adminService: AdminService) {
    this.users = [];
    this.updateUserList();
  }

  ngOnInit() {
  }

  updateUserList() {
    console.log('Constructing');
    this.adminService.getAllRetailers().subscribe(resp => {
      console.log('Constructed. Got: ');
      this.users = resp as User[];
      console.log(this.users);
    });
  }

  cancelRetailer(retailer: User): void {
    this.adminService.cancelRetailer(retailer).subscribe(resp => {
      const success = resp as boolean;
      const resultString = (success) ? 'success' : 'failure';
      console.log('Cancelling retailer was a ' + resultString);
      this.updateUserList();
    });
  }
  reactivateRetailer(retailer: User): void {
    this.adminService.reactivateRetailer(retailer).subscribe(resp => {
      const success = resp as boolean;
      const resultString = (success) ? 'success' : 'failure';
      console.log('Reactivate retailer was a ' + resultString);
      this.updateUserList();
    });
  }
}
