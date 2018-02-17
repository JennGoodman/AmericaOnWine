import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { InventoryService } from '../../services/inventory.service';

import { Inventory } from '../../models/Inventory';
import { query } from '@angular/core/src/render3';

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
    console.log('Inventory at start of loadInventory');
    console.log(this.inventory);

    if (!this.inventory) {
      this.iService.getAll().subscribe(inventory => this.inventory = inventory);
      console.log('Inventory Loaded');
    }

    console.log('Inventory at end of loadInventory');
    console.log(this.inventory);
  }

  doDropdown(e: Event) {
    console.log('doDropDown()');
    console.log('Event Data: ');
    console.log(e.keyCode);


    // if (e) { }
    // this.inventory.forEach(element => {
    //   if (element.brand.name) { }
    // });

  }

  doSearch() {
    console.log('Searched Query' + this.query);
    // this.router.navigate(['search/' + query]);
  }
}
