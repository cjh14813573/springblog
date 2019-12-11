import { Injectable } from '@angular/core';
import { CommonResponse } from '../util/commonResponse';
import { HttpClient } from '@angular/common/http';

import { HttpLocation } from '../util/httpLocation';

@Injectable({
  providedIn: 'root'
})
export class WidgetService {

  response: CommonResponse;
  location;

  constructor(
    private http: HttpClient
  ) {
    this.location = new HttpLocation();
   }

  getWidgetData() {
    return this.http.get('http://' + this.location.host + '/api/widget');
  }
}
