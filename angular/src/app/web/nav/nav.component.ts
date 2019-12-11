import { Component, OnInit } from '@angular/core';
import { CommonResponse } from 'src/app/util/commonResponse';
import { PageService } from 'src/app/service/page.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  navData;

  constructor(
    private pageService: PageService
  ) {
    this.pageService.getNavData().subscribe((data: CommonResponse) => {
      if (data.status === 1) {
        this.navData = data.responseBody;
      }
    });


  }

  ngOnInit() {
  }

}
