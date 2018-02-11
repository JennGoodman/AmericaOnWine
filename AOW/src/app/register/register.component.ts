import { Component, OnInit, Input } from '@angular/core';

import {NgForm} from '@angular/forms';  

import {User} from '../../models/User'
//import {User} from '../user';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
//@Input() public user: User;
@Input() public user: User =new User();
id: number;
email: string;
username: string;
password: string;
accountType: String;
active: number;
cancceled: number;


  constructor() { 
  }

  ngOnInit() {
  }

  register(){
    if(this.email==null || this.username==null || this.password==null || this.accountType==null){
      alert("Need to fill out all the fields");
    }
    else{
      this.user.id =1;
      this.user.email=this.email;
      this.user.username=this.username;
      this.user.password=this.password;
      if(this.accountType === 'customer'){
        this.user.role = 1;
      } 
      else {
        this.user.role = 2;
      }
      this.user.active=0;
      this.user.cancelled=0;
    }
      console.log(this.user);
    }
    
  }

