import { Component, OnInit, Injectable } from '@angular/core';
import { Transaction } from '../../models/Transaction';

import { ApplicationRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Inventory } from '../../models/Inventory';
import { User } from '../../models/User';
import { TransactionService } from '../../services/transaction.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
@Injectable()
export class CartComponent implements OnInit {
  cartItems: Transaction[];
  sum: number;

  constructor(private ref: ApplicationRef, private router: Router, private tranService: TransactionService) {
    this.cartItems = JSON.parse(localStorage.getItem('cart')) || [];
    let val = 0;
    for (let a = 0; a < this.cartItems.length; a++) {
      val += this.cartItems[a].total;
    }
    this.sum = val;
  }

  ngOnInit() {
  }

  updateCart(item: Inventory, num: number) {
    const curUser: User = JSON.parse(localStorage.getItem('user'));
    const userId = curUser ? curUser.id : null;
    if (this.cartItems && this.cartItems.length > 0) {

      let exists = false;
      this.cartItems.forEach((transaction) => {
        if (transaction.inventory.id === item.id) {
          transaction.quantity += num;
          transaction.total += item.price * num;
          exists = true;
        }
      });

      if (!exists) {
        const tmp = new Transaction().setVals(this.cartItems[0].orderNumber, item, num, userId, item.price * num);
        this.cartItems.push(tmp);
      }
    } else {
      let ordernum;
      this.tranService.maxOrder().subscribe((val) => {
        ordernum = val;
      });
      ordernum = ordernum ? ordernum : 0;

      const t = new Transaction().setVals(ordernum, item, num, userId, item.price * num);
      this.cartItems.push(t);
    }

    this.update();
  }

  update() {
    const curUser: User = JSON.parse(localStorage.getItem('user'));
    const userId = curUser ? curUser.id : null;
    this.cartItems.forEach((item) => {
      item.userId = userId;
      if (item.quantity > item.inventory.quantity) {
        item.quantity = item.inventory.quantity;
      }
      if (item.quantity <= 0) {
        this.cartItems.splice(this.cartItems.indexOf(item), 1);
      }
      item.total = item.inventory.price * item.quantity;
    });
    let val = 0;
    for (let a = 0; a < this.cartItems.length; a++) {
      val += this.cartItems[a].total;
    }
    this.sum = val;
    localStorage.setItem('cart', JSON.stringify(this.cartItems));
    this.router.navigate(['']);
  }

  valEvent(e) {
    e.stopPropagation();
    this.update();
  }

  bigItem(item) {
    localStorage.setItem('item', JSON.stringify(item));
    this.router.navigate(['/item/']);
  }

  endEvent(e) {
    e.stopPropagation();
  }

  checkout() {
    this.router.navigate(['checkout']);
  }

  empty(e) {
    e.stopPropagation();
    this.cartItems = [];
    localStorage.setItem('cart', JSON.stringify(this.cartItems));
  }

}
