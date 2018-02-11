import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { InventoryFormComponent } from './inventory-form/inventory-form.component';

import { RetailHomeComponent } from './retail-home/retail-home.component';

import { FileUploadService } from '../services/file-upload.service';
import { UserService } from '../services/user.service';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    InventoryFormComponent,
    // CustomerRegisterAccountComponent,
    LoginComponent,
    RetailHomeComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    HttpClientModule,
    FileUploadService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
