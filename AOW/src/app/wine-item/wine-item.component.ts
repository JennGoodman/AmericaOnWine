import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Inventory } from '../../models/Inventory';

@Component({
  selector: 'app-wine-item',
  templateUrl: './wine-item.component.html',
  styleUrls: ['./wine-item.component.css']
})
export class WineItemComponent implements OnInit {
  @Input() invItem: Inventory;

  constructor(private router: Router) {
  }

  getColor() {
    if (this.invItem && this.invItem.sub_type && this.invItem.sub_type.type) {
      switch (this.invItem.sub_type.type.name) {
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
    if (this.invItem && this.invItem.sub_type && this.invItem.sub_type.type) {
      switch (this.invItem.sub_type.type.name) {
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
    localStorage.setItem('item', JSON.stringify(this.invItem));
    this.router.navigate(['/item/']);
  }
}
