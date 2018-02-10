import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InventoryFormComponent } from './inventory-form/inventory-form.component';
import { WineListComponent } from './wine-list/wine-list.component';
import { AppComponent } from './app.component';

<<<<<<< HEAD
const routes: Routes = [
  {
    path: 'retailer/form',
    component: InventoryFormComponent
  },
  {
    path: 'items',
    component: WineListComponent
  },
  {
    path: '',
    component: AppComponent
  }
=======
import { RetailHomeComponent } from './retail-home/retail-home.component';

const routes: Routes = [
    {
        path : '',
        redirectTo : '/retail/home',
        pathMatch : 'full'
    },
    {
        path: 'retail/home',
        component: RetailHomeComponent,
        pathMatch : 'full'
    }
>>>>>>> d0b40ff703d3bf8572b6ac58bce64573b4e1156a
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
