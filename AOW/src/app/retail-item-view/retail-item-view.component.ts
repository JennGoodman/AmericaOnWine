import { Component, Input, OnInit, Injectable } from '@angular/core';

import { InventoryItem } from '../../models/inventory-item';

@Component({
  selector: 'app-retail-item-view',
  templateUrl: './retail-item-view.component.html',
  styleUrls: ['./retail-item-view.component.css']
})
@Injectable()
export class RetailItemViewComponent implements OnInit {
    @Input() invItem: InventoryItem;
    constructor() { }
    ngOnInit() {}
    editPressed(): void {
        console.log('[---] Edit Pressed!!');
    }

    removePressed(): void {
        console.log('[---] Remove Pressed!!');
    }
}
