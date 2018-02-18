import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { InventoryService } from '../../services/inventory.service';

import { Inventory } from '../../models/Inventory';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  inventory: Inventory[];
  query: string;

  constructor(
    private iService: InventoryService,
    private router: Router
  ) { }

  ngOnInit() { }

  loadInventory() {
    if (!this.inventory) {
      this.iService.getAll().subscribe(inventory => this.inventory = inventory);
    }
  }

  doDropdown() {
    console.log('Inventory: ');
    console.log(this.inventory);
  }

  doSearch(e: Event) {
    this.router.navigate(['search/' + this.query]);
  }
}
