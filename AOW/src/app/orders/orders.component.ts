import { Component, OnInit } from '@angular/core';
import { Transaction } from '../../models/Transaction';
import { TransactionService } from '../../services/transaction.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orders: Transaction[] = [];

  constructor(private tranService: TransactionService) {
      this.tranService.getForUser().subscribe((items) => {
        this.orders = items;
      });
   }

  ngOnInit() {
  }

}
