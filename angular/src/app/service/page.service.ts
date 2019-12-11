import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpLocation } from '../util/httpLocation';

@Injectable({
  providedIn: 'root'
})
export class PageService {

  location;

  constructor(
    private http: HttpClient,
  ) {
    this.location = new HttpLocation();
  }

  getNavData() {
    return this.http.get('http://' + this.location.host + '/api/nav');
  }

  getPage(id) {
    return this.http.get('http://' + this.location.host + '/api/page/' + id);
  }
}
