import { Component, OnInit } from '@angular/core';
import { BlogService } from 'src/app/service/blog.service';
import { CommonResponse } from 'src/app/util/response/commonResponse';
import { PageResponse } from 'src/app/util/response/page/pageResponse';

@Component({
  selector: 'app-home-main',
  templateUrl: './home-main.component.html',
  styleUrls: ['./home-main.component.css']
})
export class HomeMainComponent implements OnInit {

  pageResponse: PageResponse;

  constructor(
    private blogService: BlogService
  ) { }

  ngOnInit() {
    this.refresh(0);
  }

  refresh(page: number) {
    this.blogService.getBlogsByPage(page).subscribe((data: CommonResponse) => {
      if (data.status === 1) {
        this.pageResponse = data.responseBody;
      }
    });
  }

  goPage(page) {
    this.refresh(page);
  }

  goPrevious() {
    this.refresh(this.pageResponse.number - 1);
  }

  goNext() {
    this.refresh(this.pageResponse.number + 1);
  }

}
