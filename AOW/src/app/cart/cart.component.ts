import { Component, OnInit, Injectable } from '@angular/core';
import { Transaction } from '../../models/Transaction';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
@Injectable()
export class CartComponent implements OnInit {
  cartItems: Transaction[];

  constructor() {
    this.cartItems = JSON.parse(localStorage.getItem('cart'));
  }

  ngOnInit() {
  }

  updateCart() {
    // console.log('why isn\'t it calling me');
    this.cartItems = JSON.parse(localStorage.getItem('cart'));
    // console.log(this.cartItems);
  }

}
