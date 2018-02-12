import { Component, OnInit, Input } from '@angular/core';

import {NgForm} from '@angular/forms';  


import { User } from '../../models/User';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  check: User[];
  userRegistered: User;
  found: boolean;
  constructor(private service: UserService, private router: Router) { 
  }

  ngOnInit() {
  }

  register(email: string,
    username: string,
    password: string,
    accountType: String){
    if(email=="" || username=="" || password=="" || accountType==""){
      alert("Need to fill out all the fields");
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
      } 
      else {
        user.role = 1;
      }
      //need to update values for active and cancelled
      user.active=0;
      user.cancelled=0;
      console.log(user);

      //check current user accounts so that there is no duplicate
      this.service.getAll().subscribe(resp => {
        this.check = resp as User[];
        for(let a of this.check){
          if(a.username === user.username){
            this.found = true;
            
          }
        }
      });

      //tell yous username is taken if found
      if(this.found){
        alert("Username is taken, try again");
      }
      //creates a new userand redirects them to proper home page
      else {
        this.service.add(user).subscribe(resp => {
          this.userRegistered = resp as User;
          if (this.userRegistered == null) {
            alert("Registration failed");
          } else {
            if(accountType === 'retailer'){
              //go to retailer home page
              this.router.navigate(['retailer/home']);
            } else{
              //go to customer home page
              //this.router.navigate(['customer/home']);
            } 
          }
        });
      }
    }
      
    }

  // register(){
  //   if(this.email==null || this.username==null || this.password==null || this.accountType==null){
  //     alert("Need to fill out all the fields");
  //   }
  //   else{
  //     this.user.id =1;
  //     this.user.email=this.email;
  //     this.user.username=this.username;
  //     this.user.password=this.password;
  //     if(this.accountType === 'customer'){
  //       this.user.role = 1;
  //     } 
  //     else {
  //       this.user.role = 2;
  //     }
  //     this.user.active=0;
  //     this.user.cancelled=0;
  //   }
  //     console.log(this.user);
  //   }
    
  }

