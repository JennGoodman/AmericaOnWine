import { Component, OnInit } from '@angular/core';
import { Transaction } from '../../models/Transaction';
import { TransactionService } from '../../services/transaction.service';
import { Inventory } from '../../models/Inventory';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orders: Transaction[] = [];

  constructor(private tranService: TransactionService) {
      this.tranService.getAll().subscribe((items) => {
        this.orders = items.sort((t1, t2) => {
          return t2.orderNumber - t1.orderNumber;
        });
      });
   }

  ngOnInit() {
  }

  backgroundColor(item: Inventory) {
    if (item && item.subType && item.subType.type) {
      switch (item.subType.type.name) {
        case 'Red': return '#660033';
        case 'White': return '#ffff99';
        case 'Rosé': return '#ffcce6';
        case 'Champagne': return '#ffffe6';
      }
    }
  }

  textColor(item: Inventory) {
    if (item && item.subType && item.subType.type) {
      switch (item.subType.type.name) {
        case 'Red': return '#ffffff';
        default: return '#000000';
      }
    }
  }

  rated(item: Transaction, num: number) {
    item.rating = num;
    this.submitChanges(item);
  }

  submitChanges(item: Transaction) {
    this.tranService.update(item);
  }

  checked(item: Transaction, num: number): string {
    if (item.rating === num) {
      return 'checked';
    } else {
      return '';
    }
  }

}
