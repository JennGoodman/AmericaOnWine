import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Inventory } from '../../models/Inventory';
import { InventoryService } from '../../services/inventory.service';

@Component({
  selector: 'app-wine-item',
  templateUrl: './wine-item.component.html',
  styleUrls: ['./wine-item.component.css']
})
export class WineItemComponent implements OnInit {
  @Input() invItem: Inventory;

  @Input() isCustomer: boolean;

  constructor(private router: Router, private is: InventoryService) { }

  getColor() {
    if (this.invItem && this.invItem.subType && this.invItem.subType.type) {
      switch (this.invItem.subType.type.type) {
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
      switch (this.invItem.subType.type.type) {
        case 'Red': return '#ffffff';
        default: return '#000000';
      }
    }
  }

  addToCart(e) {
    e.stopPropagation();

    console.log('this is a stub, adding to cart has not been implemented');
    return;
  }

  viewItem() {
    if (this.isCustomer) {
      localStorage.setItem('item', JSON.stringify(this.invItem));
      console.log(localStorage.getItem('item'));
      this.router.navigate(['/item/']);
    }
  }

  editPressed(e): void {
    console.log('[---] Edit Pressed!!');
    console.log(e);
    // this.is.update(e.target)

  }

  removePressed(): void {
      console.log('[---] Remove Pressed!!');
  }
}
