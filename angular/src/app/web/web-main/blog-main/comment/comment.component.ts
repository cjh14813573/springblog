import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CommentService } from 'src/app/service/comment.service';
import { CommonResponse } from 'src/app/util/response/commonResponse';


@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  comments;
  blogId;
  errors;

  commentPostFormGroup = new FormGroup({
    name: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    website: new FormControl(''),
    content: new FormControl('', Validators.required)
  });

  constructor(
    private route: ActivatedRoute,
    private commentService: CommentService
  ) {
    this.route.paramMap.subscribe(param => {
      this.blogId = +param.get('blogId');
    });
  }

  ngOnInit() {
    this.refresh();
  }

  refresh() {
    this.commentService.getCommentsByBlogId(this.blogId).subscribe((data: CommonResponse) => {
      if (data.status === 1) {
        this.comments = data.responseBody;
      }
    });
  }

  onSubmit() {
    const postData = this.commentPostFormGroup.value;
    postData.blogId = this.blogId;
    this.commentService.addComment(this.blogId, postData).subscribe((data: CommonResponse) => {
      if (data.status === 1) {
        this.commentPostFormGroup.reset();
        this.errors = null;
        this.refresh();
      } else {
        console.log(data);
        this.errors = data.responseBody;
      }
    });
  }

}
