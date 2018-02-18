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

  constructor(
    private iService: InventoryService,
    private route: ActivatedRoute,
    private router: Router) { }

  async ngOnInit() {
    let query: string;
    await this.route.params.subscribe(params => query = params['query'].toLowerCase());
    await this.iService.getAll().subscribe(inventory => {
      if (query.length > 0) {
        const searchTerms = query.split(' ');
        if (inventory.length > 0) {
          searchTerms.forEach(term => {
            for (let index = 0; index < inventory.length; index++) {
              const element = inventory[index];
              if (element.status === 2) {
                if (element.name.toLowerCase().indexOf(term) >= 0) {
                  if (!this.results.includes(element)) {
                    this.results.push(element);
                  }
                } else if (element.brand.name.toLowerCase().indexOf(term) >= 0) {
                  if (!this.results.includes(element)) {
                    this.results.push(element);
                  }
                } else if (element.country.name.toLowerCase().indexOf(term) >= 0) {
                  if (!this.results.includes(element)) {
                    this.results.push(element);
                  }
                } else if (element.description.toLowerCase().indexOf(term) >= 0) {
                  if (!this.results.includes(element)) {
                    this.results.push(element);
                  }
                } else if (element.subType.name.toLowerCase().indexOf(term) >= 0) {
                  if (!this.results.includes(element)) {
                    this.results.push(element);
                  }
                } else if (element.subType.type.name.toLowerCase().indexOf(term) >= 0) {
                  if (!this.results.includes(element)) {
                    this.results.push(element);
                  }
                } else if (element.year.toString().toLowerCase().indexOf(term) >= 0) {
                  if (!this.results.includes(element)) {
                    this.results.push(element);
                  }
                } else if (element.price.toString().toLowerCase().indexOf(term) >= 0) {
                  if (!this.results.includes(element)) {
                    this.results.push(element);
                  }
                }
              }
            }
          });
        } else {
          console.log('Inventory Returned NULL or Empty!');
        }

      } else {
        console.log('No Search Terms!');
      }
    });
  }

  showDetail(inv: Inventory) {
    localStorage.setItem('item', JSON.stringify(inv));
    this.router.navigate(['item']);
  }
}
