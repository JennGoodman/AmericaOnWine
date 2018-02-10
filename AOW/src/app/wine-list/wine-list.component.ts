import { Component, OnInit, Injectable } from '@angular/core';
import { InventoryItem } from '../../models/inventory-item';

@Component({
  selector: 'app-wine-list',
  templateUrl: './wine-list.component.html',
  styleUrls: ['./wine-list.component.css']
})
@Injectable()
export class WineListComponent implements OnInit {
  items: InventoryItem[] = [new InventoryItem().setVals('Delicious', 1900, 'red', 'france', 'syrah'), 
                            new InventoryItem().setVals('Tasty', 1975, 'white', 'italy', 'zinfandel')];

  constructor() { }

  ngOnInit() {
  }

}
