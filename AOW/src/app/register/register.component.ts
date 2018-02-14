import { Component, OnInit, Input } from '@angular/core';

import {NgForm} from '@angular/forms';  


import { User } from '../../models/User';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountAccessService } from '../../services/account-access.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  fieldsIncomplete: boolean;
  registerFailed: boolean;
  check: User[];
  userRegistered: User;
  found: boolean;
  constructor(private service: AccountAccessService, private router: Router) { 
    this.fieldsIncomplete = false;
    this.found = false;
    this.registerFailed = false;
  }

  ngOnInit() {
  }

  register(email: string,
    username: string,
    password: string,
    accountType: String){
    if(email=="" || username=="" || password=="" || accountType==""){
      //alert("Need to fill out all the fields");
      this.fieldsIncomplete = true;
    }
    else{
      const user: User =new User();
      //const check: User = new User();
      user.id =1;
      user.email=email;
      user.username=username;
      user.password=password;
      if(accountType === 'customer'){
        user.role = 2;
        user.active=1;
      } 
      else {
        user.role = 1;
        user.active=0;
      }
      user.cancelled=0;
      console.log(user);

      //check current user accounts so that there is no duplicate
      // this.service.getAll().subscribe(resp => {
      //   this.check = resp as User[];
      //   for(let a of this.check){
      //     if(a.username === user.username){
      //       this.found = true;
            
      //     }
      //   }
      // });

      //tell yous username is taken if found
      // if(this.found){
      //   alert("Username is taken, try again");
      // }
      //creates a new userand redirects them to proper home page
      //else {
        this.service.register(user).subscribe(resp => {
          this.userRegistered = resp as User;
          if (this.userRegistered == null) {
            this.registerFailed = true;
          } else {
            if(accountType === 'retailer'){
              //go to retailer home page
              this.router.navigate(['retailer/home']);
            } else{
              //go to customer home page
              this.router.navigate(['customer/home']);
            } 
          }
        });
      //}
    } 
    }
  }

