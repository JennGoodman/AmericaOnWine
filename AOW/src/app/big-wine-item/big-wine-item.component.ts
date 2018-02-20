import { Component, OnInit, Injectable } from '@angular/core';
import { Inventory } from '../../models/Inventory';
import { Router } from '@angular/router';
import { Transaction } from '../../models/Transaction';
import { User } from '../../models/User';
import { TransactionService } from '../../services/transaction.service';

@Component({
  selector: 'app-big-wine-item',
  templateUrl: './big-wine-item.component.html',
  styleUrls: ['./big-wine-item.component.css']
})
@Injectable()
export class BigWineItemComponent implements OnInit {
  num = 1;
  invItem: Inventory = JSON.parse(localStorage.getItem('item'));

  constructor(private router: Router, private tranService: TransactionService) { }

  ngOnInit() {
  }

  routeBack() {
    this.router.navigate(['']);
    document.getElementsByTagName('body')[0].style.background = '#ffffff';
  }

  setColor() {
    if (this.invItem && this.invItem.subType && this.invItem.subType.type) {
      switch (this.invItem.subType.type.name) {
        case 'Red': return '#660033';
        case 'White': return '#ffff99';
        case 'Rosé': return '#ffcce6';
        case 'Champagne': return '#ffffe6';
      }
    }
  }

  textColor() {
    if (this.invItem && this.invItem.subType && this.invItem.subType.type) {
      switch (this.invItem.subType.type.name) {
        case 'Red': return '#ffffff';
        default: return '#000000';
      }
    }
  }

  addToCart() {
    if (this.num <= 0) {
      return;
    } else if (this.num > this.invItem.quantity) {
      this.num = this.invItem.quantity;
    }
    const ts = <Transaction[]> JSON.parse(localStorage.getItem('cart'));
    const curUser: User = JSON.parse(localStorage.getItem('user'));
    const userId = curUser ? curUser.id : null;
    if (ts && ts.length > 0) {

      let exists = false;
      ts.forEach((transaction) => {
        if (transaction.inv.id === this.invItem.id) {
          transaction.quantity += this.num;
          if (transaction.quantity > transaction.inv.quantity) {
            transaction.quantity = transaction.inv.quantity;
          }
          transaction.total += this.invItem.price * this.num;
          exists = true;
        }
      });

      if (!exists) {
        const tmp = new Transaction().setVals(ts[0].orderNumber, this.invItem, this.num, userId, this.invItem.price * this.num);
        const tmpa: Transaction[] = [tmp].concat(ts);
        localStorage.setItem('cart', JSON.stringify(tmpa));
      } else {
        localStorage.setItem('cart', JSON.stringify(ts));
      }
    } else {
      let ordernum;
      this.tranService.maxOrder().subscribe((val) => {
        ordernum = val;
      });
      ordernum = ordernum ? ordernum : 0;

      const t = [new Transaction().setVals(ordernum, this.invItem, this.num, userId, this.invItem.price * this.num)];
      localStorage.setItem('cart', JSON.stringify(t));
    }

    this.router.navigate(['']);
  }

}
