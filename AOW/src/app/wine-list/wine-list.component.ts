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
    console.log(localStorage.getItem('user'));
    if (localStorage.getItem('user') != null) {
      this.isCustomer = JSON.parse(localStorage.getItem('user')).role === 2;
    } else {
      this.isCustomer = true;
    }
    console.log(this.isCustomer);
  }

  ngOnInit() {
  }

  getSpacing() {
    const wid = document.getElementById('wine').clientWidth;
    const num = Math.floor(wid / 270);
    let space = wid - (num * 270);
    if (space < 40) {
      space = 40;
    }
    return (space / ((num + 2) * 2)).toString() + 'px 17px';
  }

}
