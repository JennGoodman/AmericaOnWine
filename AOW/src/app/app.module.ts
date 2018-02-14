import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { InventoryFormComponent } from './inventory-form/inventory-form.component';
// import { CustomerRegisterAccountComponent } from './customer-register-account/customer-register-account.component';
import { WineItemComponent } from './wine-item/wine-item.component';
import { WineListComponent } from './wine-list/wine-list.component';
import { RetailHomeComponent } from './retail-home/retail-home.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { RetailItemViewComponent } from './retail-item-view/retail-item-view.component';
import { BigWineItemComponent } from './big-wine-item/big-wine-item.component';

import { NavbarComponent } from './navbar/navbar.component';

import { FileUploadService } from '../services/file-upload.service';
import { UserService } from '../services/user.service';
import { AccountAccessService } from '../services/account-access.service';
import { BrandService } from '../services/brand.service';
import { CountryService } from '../services/country.service';
import { InventoryService } from '../services/inventory.service';
import { SubTypeService } from '../services/sub-type.service';
import { TagService } from '../services/tag.service';
import { TransactionService } from '../services/transaction.service';
import { TypeService } from '../services/type.service';
import { HomeComponent } from './home/home.component';
import { CustomerHomeComponent } from './customer-home/customer-home.component';

@NgModule({
  declarations: [
    AppComponent,
    InventoryFormComponent,
    RegisterComponent,
    RetailHomeComponent,
    NavbarComponent,
    LoginComponent,
    RetailHomeComponent,
    RetailItemViewComponent,
    WineItemComponent,
    WineListComponent,
    BigWineItemComponent,
    HomeComponent,
    CustomerHomeComponent
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
    UserService,
    AccountAccessService,
    BrandService,
    CountryService,
    InventoryService,
    SubTypeService,
    TagService,
    TransactionService,
    TypeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
