import { Component, OnInit, Injectable } from '@angular/core';
import { Inventory } from '../../models/Inventory';
import { Router } from '@angular/router';

@Component({
  selector: 'app-big-wine-item',
  templateUrl: './big-wine-item.component.html',
  styleUrls: ['./big-wine-item.component.css']
})
@Injectable()
export class BigWineItemComponent implements OnInit {

  invItem: Inventory = JSON.parse(localStorage.getItem('item'));

  constructor(private router: Router) { }

  ngOnInit() {
  }

  routeBack() {
    this.router.navigate(['']);
    document.getElementsByTagName('body')[0].style.background = '#ffffff';
  }

  setColor() {
    if (this.invItem && this.invItem.subType && this.invItem.subType.type) {
      switch (this.invItem.subType.type.name) {
        case 'Red': return '#660033';
        case 'White': return '#ffff99';
        case 'Rosé': return '#ffcce6';
        case 'Champagne': return '#ffffe6';
      }
    }
  }

  textColor() {
    if (this.invItem && this.invItem.subType && this.invItem.subType.type) {
      switch (this.invItem.subType.type.name) {
        case 'Red': return '#ffffff';
        default: return '#000000';
      }
    }
  }

}
