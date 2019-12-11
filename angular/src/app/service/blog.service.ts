import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonResponse } from '../util/commonResponse';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  response: CommonResponse;

  constructor(
    private http: HttpClient,
  ) { }

  getAllBlogs() {
    return this.http.get('http://localhost:8080/api/blog');
  }

  getOneBlog(blogId) {
    return this.http.get('http://localhost:8080/api/blog/' + blogId);
  }

  getComments(blogId){
    return this.http.get('http://localhost:8080/api/comment/blog/' + blogId);
  }
}
