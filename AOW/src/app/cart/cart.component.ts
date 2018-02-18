import { Component, OnInit, Injectable } from '@angular/core';
import { Transaction } from '../../models/Transaction';
import { ApplicationRef } from '@angular/core';
import { NgZone } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
@Injectable()
export class CartComponent implements OnInit {
  cartItems: Transaction[] = JSON.parse(localStorage.getItem('cart')) || [];
  sum: number;

  constructor(private ref: ApplicationRef, private zone: NgZone) {
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
    this.zone.run(() => {
      this.cartItems = [];
      const items = [].concat(JSON.parse(localStorage.getItem('cart')));
      this.cartItems = items;
      console.log(this.cartItems);
      let val = 0;
      for (let a = 0; a < this.cartItems.length; a++) {
        val += this.cartItems[a].total;
      }
      this.sum = val;
      this.ref.tick();
    });
  }

}
