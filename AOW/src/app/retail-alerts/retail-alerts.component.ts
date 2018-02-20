import { Component, OnInit, AfterViewChecked } from '@angular/core';
import { Router } from '@angular/router';
import { InventoryService } from '../../services/inventory.service';
import { Inventory } from '../../models/Inventory';

@Component({
  selector: 'app-retail-alerts',
  templateUrl: './retail-alerts.component.html',
  styleUrls: ['./retail-alerts.component.css']
})
export class RetailAlertsComponent implements OnInit {

  items: Inventory[];
  constructor(private service: InventoryService, private router: Router) {
    this.items = [];
  }

  ngOnInit() {
    this.updateItems();
  }

  updateItems(): void {
    this.service.getAll().subscribe(resp => {
      const tempItems = resp as Inventory[];
      this.items = [];
      console.log(JSON.parse(localStorage.getItem('user')));
      tempItems.forEach(element => {
        console.log(element);
        if (element.quantity === 0) {
          this.items.push(element);
        }
      });
    });
  }

  routeToItem(item: Inventory) {
    localStorage.setItem('invItemClicked', JSON.stringify(item));
    this.router.navigate(['/retailer/form']);
  }
}
