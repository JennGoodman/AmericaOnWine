import { Component, OnInit, Injectable} from '@angular/core';
import { User } from '../../models/User';

import { FileUploadService } from '../../services/file-upload.service';

// import { RetailItemViewComponent } from '../retail-item-view.component';
import { Inventory } from '../../models/Inventory';
import { InventoryService } from '../../services/inventory.service';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
@Injectable()
export class CustomerHomeComponent implements OnInit {

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
