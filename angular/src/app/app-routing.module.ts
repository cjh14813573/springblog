import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WebMainComponent } from './web/web-main/web-main.component';
import { HomeMainComponent } from './web/web-main/home-main/home-main.component';
import { BlogMainComponent } from './web/web-main/blog-main/blog-main.component';
import { PageComponent } from './web/page/page.component';
import { AdminMainComponent } from './admin/admin-main/admin-main.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { CategoryMainComponent } from './web/web-main/category-main/category-main.component';


const appRoutes: Routes = [
  {
    path: 'home', component: WebMainComponent, children: [
      { path: '', component: HomeMainComponent },
      { path: 'blog/:blogId', component: BlogMainComponent },
      { path: 'category/:categoryId', component: CategoryMainComponent }
    ]
  },
  { path: 'page/:pageId', component: PageComponent },
  {
    path: 'admin', component: AdminMainComponent,
    children: [
      { path: '', component: HomeMainComponent },
      { path: 'blog', component: BlogMainComponent },
    ]
  },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes, { enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
