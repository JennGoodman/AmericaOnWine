import { Component, OnInit, Injectable } from '@angular/core';

import { FileUploadService } from '../../services/file-upload.service';

// import { RetailItemViewComponent } from '../retail-item-view.component';
import { InventoryItem } from '../../models/inventory-item';

@Component({
  selector: 'app-retail-home',
  templateUrl: './retail-home.component.html',
  styleUrls: ['./retail-home.component.css']
})
@Injectable()
export class RetailHomeComponent implements OnInit {

  constructor(private fus : FileUploadService) { }
  items: InventoryItem[] = [new InventoryItem().setVals('Delicious', 1900, 'red', 'france', 'syrah'),
                            new InventoryItem().setVals('Tasty', 1975, 'white', 'italy', 'zinfandel')];
  ngOnInit() {
  }
    fileInput(fileInput : any) {
        this.fus.upload(fileInput);
    }

}
