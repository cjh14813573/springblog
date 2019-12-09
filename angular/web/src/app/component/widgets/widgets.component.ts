import { Component, OnInit } from '@angular/core';
import { BlogService } from 'src/app/service/blog.service';

@Component({
  selector: 'app-widgets',
  templateUrl: './widgets.component.html',
  styleUrls: ['./widgets.component.css']
})
export class WidgetsComponent implements OnInit {

  constructor(
    private widgetsService: BlogService
  ) {

   }

  ngOnInit() {
    console.log(this.widgetsService.getWidgetData());
  }

}
