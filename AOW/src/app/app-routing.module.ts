import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InventoryFormComponent } from './inventory-form/inventory-form.component';
import { WineListComponent } from './wine-list/wine-list.component';
import { AppComponent } from './app.component';

import { RetailHomeComponent } from './retail-home/retail-home.component';
import { LoginComponent } from './login/login.component';
import { BigWineItemComponent } from './big-wine-item/big-wine-item.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
    {
        path: '',
        component: AppComponent,
        pathMatch: 'full'
    },
    {
        path: 'retailer/home',
        component: RetailHomeComponent,
        pathMatch : 'full'
    },
    {
        path: 'login',
        component: LoginComponent,
        pathMatch: 'full'
    },
    {
        path: 'register',
        component: RegisterComponent,
        pathMatch: 'full'
    },
    {
        path: 'retailer/form',
        component: InventoryFormComponent,
        pathMatch: 'full'
    },
    {
        path: 'items',
        component: WineListComponent,
        pathMatch: 'full'
    },
    {
        path: 'item',
        component: BigWineItemComponent,
        pathMatch: 'full'
    },
    {
        path: 'form',
        component: InventoryFormComponent,
        pathMatch: 'full'
    }
    
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
