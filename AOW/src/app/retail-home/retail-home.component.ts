import { Component, OnInit, Injectable } from '@angular/core';

import { FileUploadService } from '../../services/file-upload.service';

// import { RetailItemViewComponent } from '../retail-item-view.component';
import { Inventory } from '../../models/Inventory';
import { InventoryService } from '../../services/inventory.service';

@Component({
  selector: 'app-retail-home',
  templateUrl: './retail-home.component.html',
  styleUrls: ['./retail-home.component.css']
})
@Injectable()
export class RetailHomeComponent implements OnInit {

  constructor(private fus: FileUploadService, private invService: InventoryService) {
    this.invService.getAll().subscribe(items => {
      this.items = items;
    });
  }

  items: Inventory[] = [];
  ngOnInit() {
  }

  fileInput(fileInput: any) {
    this.fus.upload(fileInput);
  }

}
