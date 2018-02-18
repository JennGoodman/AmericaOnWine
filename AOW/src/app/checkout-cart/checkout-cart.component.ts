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
  cartItems: Transaction[] = JSON.parse(localStorage.getItem('cart')) || [];
  invalidLen: boolean =false;
  newVal: String;


  constructor(private router: Router) { 
  }

  ngOnInit() {
  }

  verify(num: number){
    console.log(num);
    this.newVal= num.toString();
    console.log(num.toString().length);
    if(this.newVal.length == 16){
      this.router.navigate(['items']);
      localStorage.setItem('cart', null);
    }else {
      this.invalidLen = true;
    }
  }

}

//local storage, get item cart, transaction array
