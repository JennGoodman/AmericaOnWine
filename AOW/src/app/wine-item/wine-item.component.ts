import { Component, OnInit, Input } from '@angular/core';
import { InventoryItem } from '../../models/inventory-item';

@Component({
  selector: 'app-wine-item',
  templateUrl: './wine-item.component.html',
  styleUrls: ['./wine-item.component.css']
})
export class WineItemComponent implements OnInit {
  @Input() invItem: InventoryItem;

  constructor() {
   }

  ngOnInit() {
  }

  getColor() {
    switch (this.invItem.type) {
      case 'Red': return '#660033';
      case 'White': return '#ffff99';
      case 'Rosé': return '#ffcce6';
      case 'Champagne': return '#ffffe6';
    }
  }

  textColor() {
    switch (this.invItem.type) {
      case 'Red': return '#ffffff';
      default: return '#000000';
    }
  }
}
