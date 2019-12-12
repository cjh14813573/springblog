import { Component, OnInit } from '@angular/core';
import { BlogService } from 'src/app/service/blog.service';
import { ActivatedRoute } from '@angular/router';
import { CommonResponse } from 'src/app/util/response/commonResponse';

@Component({
  selector: 'app-blog-main',
  templateUrl: './blog-main.component.html',
  styleUrls: ['./blog-main.component.css']
})
export class BlogMainComponent implements OnInit {

  blog;

  constructor(
    private blogService: BlogService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.blogService.getOneBlog(+params.get('blogId')).subscribe((data: CommonResponse) => {
        if (data.status === 1) {
          this.blog = data.responseBody;
        }
      });
    });
  }

}
