import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './web/nav/nav.component';
import { FooterComponent } from './web/footer/footer.component';
import { WidgetsComponent } from './web/web-main/widgets/widgets.component';
import { HomeMainComponent } from './web/web-main/home-main/home-main.component';
import { BlogMainComponent } from './web/web-main/blog-main/blog-main.component';
import { WebMainComponent } from './web/web-main/web-main.component';
import { PageComponent } from './web/page/page.component';
import { AdminMainComponent } from './admin/admin-main/admin-main.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { CommentComponent } from './web/web-main/blog-main/comment/comment.component';
import { CategoryMainComponent } from './web/web-main/category-main/category-main.component';
import { PaginationComponent } from './web/web-main/pagination/pagigation.component';




@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    WidgetsComponent,
    HomeMainComponent,
    BlogMainComponent,
    WebMainComponent,
    PageComponent,
    AdminMainComponent,
    NotFoundComponent,
    CommentComponent,
    CategoryMainComponent,
    PaginationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
