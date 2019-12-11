import { Component, OnInit } from '@angular/core';
import { BlogService } from 'src/app/service/blog.service';
import { CommonResponse } from 'src/app/util/commonResponse';

@Component({
  selector: 'app-home-main',
  templateUrl: './home-main.component.html',
  styleUrls: ['./home-main.component.css']
})
export class HomeMainComponent implements OnInit {

  blogs;

  constructor(
    private blogService: BlogService
  ) { }

  ngOnInit() {
    this.blogService.getAllBlogs().subscribe((data:CommonResponse)=>{
      if(data.status === 1){
        this.blogs = data.responseBody;
      }
    });
  }

}
