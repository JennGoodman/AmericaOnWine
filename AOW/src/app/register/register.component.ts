import { Component, OnInit, Input } from '@angular/core';

import {NgForm} from '@angular/forms';  

//import {User} from '../user'


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
//@Input() public user: User;
email: string;
username: string;
password: string;
accountType: string;

  constructor() { }

  ngOnInit() {
  }

  register(){
    if(this.email==null || this.username==null || this.password==null || this.accountType==null){
      alert("Need to fill out all the fields");
    }else{
      console.log(this.email);
      console.log(this.username);
      console.log(this.password);
      console.log(this.accountType);
    }
    
  }

  

}
