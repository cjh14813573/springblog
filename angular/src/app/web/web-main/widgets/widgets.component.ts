import { Component, OnInit } from '@angular/core';
import { CommonResponse } from 'src/app/util/commonResponse';
import { WidgetService } from 'src/app/service/widget.service';

@Component({
  selector: 'app-widgets',
  templateUrl: './widgets.component.html',
  styleUrls: ['./widgets.component.css']
})
export class WidgetsComponent implements OnInit {


  widgetsData;

  constructor(
    private widgetsService: WidgetService
  ) {
    this.widgetsService.getWidgetData().subscribe((data: CommonResponse) => {
      if (data.status === 1) {
        this.widgetsData = data.responseBody;
      }
    });


  }

  ngOnInit() {
  }
}
