import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Inventory } from '../../models/Inventory';
import { Transaction } from '../../models/Transaction';
import { User } from '../../models/User';
import { TransactionService } from '../../services/transaction.service';
import { CartComponent } from '../cart/cart.component';
import { InventoryService } from '../../services/inventory.service';
import { ApplicationRef } from '@angular/core';

@Component({
  selector: 'app-wine-item',
  templateUrl: './wine-item.component.html',
  styleUrls: ['./wine-item.component.css']
})
export class WineItemComponent implements OnInit {
  @Input() invItem: Inventory;

  @Input() isCustomer: boolean;
  num = 1;

  constructor(private router: Router,
    private tranService: TransactionService,
    private cart: CartComponent,
    private is: InventoryService,
    private ref: ApplicationRef
  ) { }

  getColor() {
    if (this.invItem && this.invItem.subType && this.invItem.subType.type) {
      switch (this.invItem.subType.type.name) {
        case 'Red': return '#660033';
        case 'White': return '#ffff99';
        case 'Rosé': return '#ffcce6';
        case 'Champagne': return '#ffffe6';
      }
    }
  }

  ngOnInit() {
  }

  textColor() {
    if (this.invItem && this.invItem.subType && this.invItem.subType.type) {
      switch (this.invItem.subType.type.name) {
        case 'Red': return '#ffffff';
        default: return '#000000';
      }
    }
  }

  addToCart(e) {
    e.stopPropagation();
    if (this.num < 0) {
      return;
    }
    if (this.num > this.invItem.quantity) {
      this.num = this.invItem.quantity;
    }
    this.cart.updateCart(this.invItem, this.num);
    this.ref.tick();
  }

  endEvent(e) {
    e.stopPropagation();
  }

  viewItem() {
    if (this.isCustomer) {
      localStorage.setItem('item', JSON.stringify(this.invItem));
      console.log(localStorage.getItem('item'));
      this.router.navigate(['/item/']);
    }
  }

  editPressed(e): void {
    localStorage.setItem('invItemClicked', JSON.stringify(this.invItem));
    this.router.navigate(['/retailer/form']);
    location.reload();
  }

  removePressed(): void {
    this.is.delete(this.invItem)
      .subscribe( resp => {
          console.log(resp as Inventory);
          location.reload();
      });
  }
}
