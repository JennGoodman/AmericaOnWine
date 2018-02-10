import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

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
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
