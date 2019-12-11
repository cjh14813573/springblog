import { Injectable } from '@angular/core';
import { CommonResponse } from '../util/commonResponse';
import { HttpClient } from '@angular/common/http';
import { HttpLocation } from '../util/httpLocation';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  response: CommonResponse;
  location;

  constructor(
    private http: HttpClient,
  ) {
    this.location = new HttpLocation();
  }

  getCommentsByBlogId(blogId) {
    return this.http.get('http://' + this.location.host + '/api/comment/blog/' + blogId);
  }

  addComment(blogId, comment) {
    return this.http.post('http://' + this.location.host + '/api/comment/blog/' + blogId, comment);
  }
}
