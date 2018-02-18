import { Component, OnInit } from '@angular/core';

import {NgForm} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { InventoryService } from '../../services/inventory.service';
import { Inventory } from '../../models/Inventory';
@Component({
  selector: 'app-admin-approve-inv',
  templateUrl: './admin-approve-inv.component.html',
  styleUrls: ['./admin-approve-inv.component.css']
})
export class AdminApproveInvComponent implements OnInit {
  allInvApprovalItem: Inventory[] = new Array();
  temp: Inventory[];
  visible = false;

  constructor(private service: InventoryService, private router: Router) {
   }

  ngOnInit() {
    this.service.getAll().subscribe(resp => {
      this.temp = resp as Inventory[];
      console.log(this.temp);

      for (const a of this.temp) {
          if (a.status === 1) {
            console.log(a);
            this.allInvApprovalItem.push(a);
          }
      }
      console.log(this.allInvApprovalItem);
      if (this.allInvApprovalItem.length === 0) {
        this.visible = true;
      }
    });
  }

  approve(inv: Inventory) {
    console.log('Approving item with id of: ', inv.id, inv.status);
    inv.status = 2;
    console.log('Approving item with id of: ', inv.id, inv.status);
    this.service.approve(inv).subscribe(resp => {
      inv = resp as Inventory;
      console.log('returned inventory item is: ', inv);
    });
    // this.router.navigate(['inventory/approval']);
    window.location.reload();
  }

  deny(inv: Inventory) {
    console.log('Approving item with id of: ', inv.id, inv.status);
    inv.status = 0;
    console.log('Approving item with id of: ', inv.id, inv.status);
    this.service.approve(inv).subscribe(resp => {
      inv = resp as Inventory;
      console.log('returned inventory item is: ', inv);
    });
    window.location.reload();
    // this.router.navigate(['inventory/approval']);
  }
}
