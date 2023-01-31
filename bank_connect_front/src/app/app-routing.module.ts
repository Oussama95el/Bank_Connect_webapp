import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Router, RouterModule} from "@angular/router";

const routes = [
  {
    path: '',
    // loadChildren: () => import('./pages/pages.module').then(m => m.PagesModule)
  },
  // {
  //   path: 'auth',
  //   // loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)
  // },
  // {
  //   path: 'error',
  //   // loadChildren: () => import('./error/error.module').then(m => m.ErrorModule)
  // },
  // {
  //   path: '**',
  //   redirectTo: 'error/404'
  // }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
