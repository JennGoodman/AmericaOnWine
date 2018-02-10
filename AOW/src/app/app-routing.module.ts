import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InventoryFormComponent } from './inventory-form/inventory-form.component';
import { WineListComponent } from './wine-list/wine-list.component';
import { AppComponent } from './app.component';

import { RetailHomeComponent } from './retail-home/retail-home.component';

const routes: Routes = [
    {
        path: '',
        component: AppComponent,
        pathMatch: 'full'
    },
    {
        path: 'retail/home',
        component: RetailHomeComponent,
        pathMatch : 'full'
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
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
