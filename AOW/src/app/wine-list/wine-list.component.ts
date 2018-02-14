import { Component, OnInit, Injectable } from '@angular/core';
import { Inventory } from '../../models/Inventory';
import { InventoryService } from '../../services/inventory.service';

@Component({
  selector: 'app-wine-list',
  templateUrl: './wine-list.component.html',
  styleUrls: ['./wine-list.component.css']
})
@Injectable()
export class WineListComponent implements OnInit {
  items: Inventory[] = [];
  isCustomer: boolean;

  constructor(private invService: InventoryService) {
    this.invService.getAll().subscribe(items => {
      this.items = items;
    });
    if (localStorage.getItem('user') != null) {
      this.isCustomer = JSON.parse(localStorage.getItem('user')).role === 0;
    } else {
      this.isCustomer = true;
    }
  }

  ngOnInit() {
  }

}
