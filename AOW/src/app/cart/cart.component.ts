import { Component, OnInit, Injectable } from '@angular/core';
import { Transaction } from '../../models/Transaction';
import { ApplicationRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
@Injectable()
export class CartComponent implements OnInit {
  cartItems: Transaction[] = JSON.parse(localStorage.getItem('cart')) || [];
  sum: number;

  constructor(private ref: ApplicationRef, private router: Router) {
    this.cartItems = JSON.parse(localStorage.getItem('cart')) || [];
    let val = 0;
    for (let a = 0; a < this.cartItems.length; a++) {
      val += this.cartItems[a].total;
    }
    this.sum = val;
  }

  ngOnInit() {
  }

  updateCart() {
    setTimeout(this.update(), 3000);
  }

  update() {
    this.cartItems.forEach((item) => {
      this.cartItems.pop();
    });
    const newCart = JSON.parse(localStorage.getItem('cart'));
    newCart.forEach((item) => {
      this.cartItems.push(item);
    });
  }

  valEvent(e) {
    e.stopPropagation();
    this.cartItems.forEach((item) => {
      item.total = item.inventory.price * item.quantity;
    });
    let val = 0;
    for (let a = 0; a < this.cartItems.length; a++) {
      val += this.cartItems[a].total;
    }
    this.sum = val;
    localStorage.setItem('cart', JSON.stringify(this.cartItems));
  }

  endEvent(e) {
    e.stopPropagation();
  }

  checkout(){
    this.router.navigate(['checkout']);
  }

}
