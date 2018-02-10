import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-retail-item-view',
  templateUrl: './retail-item-view.component.html',
  styleUrls: ['./retail-item-view.component.css']
})
export class RetailItemViewComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
    editPressed(): void {
        console.log('[---] Edit Pressed!!');
    }

    removePressed(): void {
        console.log('[---] Remove Pressed!!');
    }
}
