import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './component/nav/nav.component';
import { FooterComponent } from './component/footer/footer.component';
import { WidgetsComponent } from './component/widgets/widgets.component';
import { HomeMainComponent } from './component/home-main/home-main.component';
import { BlogMainComponent } from './component/blog-main/blog-main.component';


const appRoutes: Routes = [
  { path: '', component: HomeMainComponent, outlet: 'web-main' },
  { path: 'blog', component: BlogMainComponent, outlet: 'web-main' },
];

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    WidgetsComponent,
    HomeMainComponent,
    BlogMainComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
