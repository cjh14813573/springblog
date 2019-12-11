import { Injectable } from '@angular/core';
import { CommonResponse } from '../util/commonResponse';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  response: CommonResponse;

  constructor(
    private http: HttpClient,
  ) { }

  getCommentsByBlogId(blogId) {
    return this.http.get('http://localhost:8080/api/comment/blog/' + blogId);
  }

  addComment(blogId, comment) {
    return this.http.post('http://localhost:8080/api/comment/blog/' + blogId, comment);
  }
}
