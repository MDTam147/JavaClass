import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { PageAComponent } from './page-a/page-a.component';
import { PageBComponent } from './page-b/page-b.component';
import { PageDefaultComponent } from './page-default/page-default.component';

const appRoutes: Routes = [
  { path: 'page-a', component: PageAComponent },
  { path: 'page-b/:id/:firstname', component: PageBComponent },
  { path: '', redirectTo: '/page-a', pathMatch: 'full' },
  { path: '**', component: PageDefaultComponent },
];

export const routing: ModuleWithProviders<any> =
  RouterModule.forRoot(appRoutes);
