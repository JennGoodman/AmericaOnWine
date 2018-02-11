import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { InventoryFormComponent } from './inventory-form/inventory-form.component';
// import { CustomerRegisterAccountComponent } from './customer-register-account/customer-register-account.component';
import { WineItemComponent } from './wine-item/wine-item.component';
import { WineListComponent } from './wine-list/wine-list.component';
import { RetailHomeComponent } from './retail-home/retail-home.component';
import { FileUploadService } from '../services/file-upload.service';
import { UserService } from '../services/user.service';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';

import { RetailItemViewComponent } from './retail-item-view/retail-item-view.component';
import { BigWineItemComponent } from './big-wine-item/big-wine-item.component';

@NgModule({
  declarations: [
    AppComponent,
    InventoryFormComponent,
    LoginComponent,
    RetailHomeComponent,
    RetailItemViewComponent,
    // CustomerRegisterAccountComponent,
    WineItemComponent,
    WineListComponent,
    BigWineItemComponent
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
