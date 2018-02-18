import { Component, OnInit } from '@angular/core';
import { Transaction } from '../../models/Transaction';
import {NgModule} from '@angular/core'; 
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-checkout-cart',
  templateUrl: './checkout-cart.component.html',
  styleUrls: ['./checkout-cart.component.css']
})
export class CheckoutCartComponent implements OnInit {
  //cartItems: Transaction[] = JSON.parse(localStorage.getItem('cart')) || [];
  cartItems: Transaction[] = [];
  invalidLen: boolean =false;
  newVal: String;
  sum: number;
  someArray: Transaction = new Transaction();
  

  constructor(private router: Router) { 
  }

  ngOnInit() {
    this.someArray.id = 2;
      this.someArray.orderNumber = 123;
      this.someArray.inventoryId = 4;
      this.someArray.quantity = 2;
      this.someArray.userId = 7;
      this.someArray.total = 50;
      this.someArray.rating = 8;
      this.someArray.transactionDate = null;
      this.someArray.comments = 'GOOD';
      this.cartItems.push(this.someArray);
    //this.cartItems = JSON.parse(localStorage.getItem('cart')) || [];
    let total = 0;
    for (let a = 0; a < this.cartItems.length; a++) {
      total += this.cartItems[a].total;
    }
    this.sum = total;
  }

  verify(num: number){
    console.log(num);
    this.newVal= num.toString();
    console.log(num.toString().length);
    if(this.newVal.length == 16){
      localStorage.removeItem('cart');
      this.router.navigate(['items']);
    }else {
      this.invalidLen = true;
    }
  }
}
