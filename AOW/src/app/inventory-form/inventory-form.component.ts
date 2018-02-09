import { Component, OnInit, Input } from '@angular/core';
import { InventoryItem } from '../../models/inventory-item';

@Component({
  selector: 'app-inventory-form',
  templateUrl: './inventory-form.component.html',
  styleUrls: ['./inventory-form.component.css']
})
export class InventoryFormComponent implements OnInit {
  invItem: InventoryItem;

  constructor() {
    this.invItem = new InventoryItem;
   }

  ngOnInit() {
  }

}
