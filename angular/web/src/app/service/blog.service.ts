import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonResponse } from '../util/commonResponse';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  response: CommonResponse;

  constructor(
    private http: HttpClient,
  ) { }

  getWidgetData(){
    return this.http.get('/src/test.json');
  }
}
