import { Component, OnInit } from '@angular/core';
import { User } from '../../../models/User';

@Component({
  selector: 'app-retailer-accounts',
  templateUrl: './retailer-accounts.component.html',
  styleUrls: ['./retailer-accounts.component.css']
})
export class RetailerAccountsComponent implements OnInit {

  users: User[];
  constructor() { }

  ngOnInit() {
  }

}
