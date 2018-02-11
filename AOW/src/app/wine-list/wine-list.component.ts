import { Component, OnInit, Injectable } from '@angular/core';
import { InventoryItem } from '../../models/inventory-item';

@Component({
  selector: 'app-wine-list',
  templateUrl: './wine-list.component.html',
  styleUrls: ['./wine-list.component.css']
})
@Injectable()
export class WineListComponent implements OnInit {
  items: InventoryItem[] = [new InventoryItem().setVals('Delicious', 1900, 'Red', 'France', 'Syrah'),
                            new InventoryItem().setVals('Tasty', 1975, 'White', 'Italy', 'Zinfandel'),
                            new InventoryItem().setVals('Delicious', 1900, 'Red', 'France', 'Syrah'),
                            new InventoryItem().setVals('Tasty', 1975, 'White', 'Italy', 'Zinfandel'),
                            new InventoryItem().setVals('Delicious', 1900, 'Red', 'France', 'Syrah'),
                            new InventoryItem().setVals('Tasty', 1975, 'White', 'Italy', 'Zinfandel'),
                            new InventoryItem().setVals('Delicious', 1900, 'Red', 'France', 'Syrah'),
                            new InventoryItem().setVals('Tasty', 1975, 'White', 'Italy', 'Zinfandel'),
                            new InventoryItem().setVals('Delicious', 1900, 'Red', 'France', 'Syrah'),
                            new InventoryItem().setVals('Tasty', 1975, 'Rosé', 'Italy', 'Zinfandel'),
                            new InventoryItem().setVals('Delicious', 1900, 'Red', 'France', 'Syrah'),
                            new InventoryItem().setVals('Tasty', 1975, 'White', 'Italy', 'Zinfandel'),
                            new InventoryItem().setVals('Delicious', 1900, 'Champagne', 'France', 'Syrah'),
                            new InventoryItem().setVals('Tasty', 1975, 'White', 'Italy', 'Zinfandel')];

  constructor() { }

  ngOnInit() {
  }

}
