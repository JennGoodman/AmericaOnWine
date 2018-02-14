import { Component, Input, OnInit, Injectable } from '@angular/core';

import { InventoryItem } from '../../models/inventory-item';
import { Inventory } from '../../models/Inventory';

@Component({
  selector: 'app-retail-item-view',
  templateUrl: './retail-item-view.component.html',
  styleUrls: ['./retail-item-view.component.css']
})
@Injectable()
export class RetailItemViewComponent implements OnInit {
    @Input() invItem: Inventory;
    constructor() { }
    ngOnInit() {}
    editPressed(): void {
        console.log('[---] Edit Pressed!!');
    }

    removePressed(): void {
        console.log('[---] Remove Pressed!!');
    }
}
