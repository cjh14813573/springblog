import { Injectable } from '@angular/core';
import { CommonResponse } from '../util/commonResponse';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WidgetService {

  response: CommonResponse;

  constructor(
    private http: HttpClient,
  ) { }

  getWidgetData(){
    return this.http.get('http://localhost:8080/api/widget');
  }
}
