import { Component, OnInit, Input } from '@angular/core';
import { PageService } from 'src/app/service/page.service';
import { ActivatedRoute } from '@angular/router';
import { CommonResponse } from 'src/app/util/commonResponse';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {

  page;


  constructor(
    private pageService: PageService,
    private route: ActivatedRoute
  ) {
   }

  ngOnInit() {
    this.route.paramMap.subscribe(params=>{
    this.pageService.getPage(+params.get('pageId')).subscribe((data:CommonResponse)=>{
      if(data.status === 1){
        this.page = data.responseBody;
      }
    });
    console.log(this.page);
    });
  }

}
