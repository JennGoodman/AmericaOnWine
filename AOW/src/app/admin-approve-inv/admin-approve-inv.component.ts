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

  constructor(private service: InventoryService, private router: Router) {
   }

  ngOnInit() {
    this.service.getAll().subscribe(resp => {
      this.temp = resp as Inventory[];
      console.log(this.allInvApprovalItem);

      for(let a of this.temp){
          if(a.id==1){
            this.allInvApprovalItem.push(a);
          }
      }
    })
  }

  approve(inv: Inventory){
    console.log("Approving item with id of: " + inv);
    this.service.update(inv).subscribe(resp => {
      this.router.navigate(['inventory/approval']);
    });
  }

  deny(inv: Inventory){
    console.log("Denying item with id of: " + inv);
    this.service.update(inv).subscribe(resp => {
      this.router.navigate(['inventory/approval']);
    });
  }

  // this.service.register(user).subscribe(resp => {
  //   this.userRegistered = resp as User;
  //   console.log(this.userRegistered);
  //   if (this.userRegistered == null) {
  //     this.registerFailed = true;
  //     console.log(this.registerFailed);
  //   } else {
  //     if(accountType === 'retailer'){
  //       console.log(" " +accountType + " 1");
  //       //go to retailer home page
  //       localStorage.setItem('user', JSON.stringify(this.userRegistered));
  //       this.router.navigate(['retailer/home']);
  //     } else{
  //       console.log(" " +accountType + " 2");
  //       //go to customer home page
  //       localStorage.setItem('user', JSON.stringify(this.userRegistered));
  //       this.router.navigate(['']);
  //     }
  //   }
  // });

}
