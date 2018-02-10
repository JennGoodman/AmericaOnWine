import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { InventoryFormComponent } from './inventory-form/inventory-form.component';
import { RetailHomeComponent } from './retail-home/retail-home.component';

import { FileUploadService } from '../services/file-upload.service';
import { RetailItemViewComponent } from './retail-item-view/retail-item-view.component';

// import { CustomerRegisterAccountComponent } from './customer-register-account/customer-register-account.component';
import { WineItemComponent } from './wine-item/wine-item.component';
import { WineListComponent } from './wine-list/wine-list.component';

@NgModule({
  declarations: [
    AppComponent,
    InventoryFormComponent,
    RetailHomeComponent,
    RetailItemViewComponent,
    // CustomerRegisterAccountComponent,
    WineItemComponent,
    WineListComponent
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
