import { Component, OnInit } from '@angular/core';
import { Inventory } from '../../models/Inventory';
import { TransactionService } from '../../services/transaction.service';
import { Transaction } from '../../models/Transaction';

@Component({
  selector: 'app-rate-show',
  templateUrl: './rate-show.component.html',
  styleUrls: ['./rate-show.component.css']
})
export class RateShowComponent implements OnInit {
  tx: Transaction[];

  constructor(ts: TransactionService) {
    const inv = JSON.parse(localStorage.getItem('item'));
    if (inv) {
      ts.getByItemId(inv).subscribe(tx => { this.tx = tx; });
    } else {
      console.log('invItem empty!');
    }
  }

  ngOnInit() {
  }
}
