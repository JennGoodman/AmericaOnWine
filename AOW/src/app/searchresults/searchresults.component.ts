import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { InventoryService } from '../../services/inventory.service';

import { Inventory } from '../../models/Inventory';

@Component({
  selector: 'app-searchresults',
  templateUrl: './searchresults.component.html',
  styleUrls: ['./searchresults.component.css']
})
export class SearchresultsComponent implements OnInit {

  results = new Array<Inventory>();
  query: string;

  constructor(
    private iService: InventoryService,
    private route: ActivatedRoute,
    private router: Router) { }

  async ngOnInit() {
    await this.route.params.subscribe(params => this.query = params['query'].toLowerCase());
    await this.iService.getAll().subscribe(inventory => {
      if (inventory.length > 0) {
        for (let index = 0; index < inventory.length; index++) {
          const element = inventory[index];
          if (element.status === 2) {
            if (element.name.toLowerCase().indexOf(this.query) >= 0) {
              this.results.push(element);
            } else if (element.brand.name.toLowerCase().indexOf(this.query) >= 0) {
              this.results.push(element);
            } else if (element.country.name.toLowerCase().indexOf(this.query) >= 0) {
              this.results.push(element);
            } else if (element.description.toLowerCase().indexOf(this.query) >= 0) {
              this.results.push(element);
            } else if (element.subType.name.toLowerCase().indexOf(this.query) >= 0) {
              this.results.push(element);
            } else if (element.subType.type.name.toLowerCase().indexOf(this.query) >= 0) {
              this.results.push(element);
            } else if (element.year.toString().toLowerCase().indexOf(this.query) >= 0) {
              this.results.push(element);
            } else if (element.price.toString().toLowerCase().indexOf(this.query) >= 0) {
              this.results.push(element);
            }
          }
        }
      } else {
        console.log('Inventory returned NULL or empty!');
      }
    });
  }
}
