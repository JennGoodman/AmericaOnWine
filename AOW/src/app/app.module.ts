import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { InventoryFormComponent } from './inventory-form/inventory-form.component';
import { RetailHomeComponent } from './retail-home/retail-home.component';

import { FileUploadService } from '../services/file-upload.service';


@NgModule({
  declarations: [
    AppComponent,
    InventoryFormComponent,
      //CustomerRegisterAccountComponent,
    RetailHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [FileUploadService],
  bootstrap: [AppComponent]
})
export class AppModule { }
