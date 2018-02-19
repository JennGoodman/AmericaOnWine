import { Component, OnInit } from '@angular/core';
import { Transaction } from '../../models/Transaction';
import {NgModule} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TransactionService } from '../../services/transaction.service';

@Component({
  selector: 'app-checkout-cart',
  templateUrl: './checkout-cart.component.html',
  styleUrls: ['./checkout-cart.component.css']
})
export class CheckoutCartComponent implements OnInit {
  // cartItems: Transaction[] = JSON.parse(localStorage.getItem('cart')) || [];
  cartItems: Transaction[] = [];
  invalidLen: boolean =false;
  newVal: String;
  sum: number;
  returnTransaction: Transaction;
  failed: boolean;


  constructor(private router: Router, private service: TransactionService) {
  }

  ngOnInit() {
    this.service.getAll().subscribe(resp => {
      console.log(resp);
    });

    this.cartItems = JSON.parse(localStorage.getItem('cart')) || [];
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
      for(let tran of this.cartItems){
        console.log("What about this ? " + tran.inventory);
        console.log(tran);
        tran.id=4;
        tran.orderNumber=3;
        tran.transactionDate= new Date('02-MAR-2018');
        console.log(tran);
        this.service.add(tran).subscribe(resp => {
          this.returnTransaction = resp as Transaction;
          console.log(this.returnTransaction);
          if(this.returnTransaction == null){
            console.log("failed");
            this.failed = true;
          }
        }
      );
      }
      if(this.failed == false){
        localStorage.removeItem('cart');
      this.router.navigate(['items']);
      }
    }else {
      this.invalidLen = true;
    }
  }
}
