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

  results: Inventory[];
  query: string;

  constructor(
    private iService: InventoryService,
    private route: ActivatedRoute,
    private router: Router) { }

  async ngOnInit() {
    await this.route.params.subscribe(params => this.query = params['query'].toLowerCase());
    await this.iService.getAll().subscribe(inventory => {

      console.log('Inventory Before If: ');
      console.log(inventory);
      if (inventory.length > 0) {
        console.log('Looking for: ' + this.query);

        for (let index = 0; index < inventory.length; index++) {
          const element = inventory[index];
          if (element.name.toLowerCase().indexOf(this.query) >= 0) {
            console.log('Matched query: ' + this.query + ' to: ' + element.name);
            this.results.push(element);
          } else if (element.brand.name.toLowerCase().indexOf(this.query) >= 0) {
            console.log('Matched query: ' + this.query + ' to: ' + element.brand.name);
            this.results.push(element);
          } else if (element.country.name.toLowerCase().indexOf(this.query) >= 0) {
            console.log('Matched query: ' + this.query + ' to: ' + element.country.name);
            this.results.push(element);
          } else if (element.description.toLowerCase().indexOf(this.query) >= 0) {
            console.log('Matched query: ' + this.query + ' to: ' + element.description);
            this.results.push(element);
          }
        }
      } else {
        console.log('Inventory returned NULL or empty!');
      }
    });
  }
}
