import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonResponse } from '../util/commonResponse';
import { HttpLocation } from '../util/httpLocation';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  response: CommonResponse;
  location;

  constructor(
    private http: HttpClient,
  ) {
    this.location = new HttpLocation();
   }

  getAllBlogs() {
    return this.http.get('http://' + this.location.host + '/api/blog');
  }

  getOneBlog(blogId) {
    return this.http.get('http://' + this.location.host + '/api/blog/' + blogId);
  }

  getComments(blogId){
    return this.http.get('http://' + this.location.host + '/api/comment/blog/' + blogId);
  }
}
