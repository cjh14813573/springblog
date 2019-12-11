import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpLocation } from '../util/httpLocation';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  location;

  constructor(
    private http: HttpClient,
  ) {

    this.location = new HttpLocation();
  }


  getCategoryById(categoryId) {
    return this.http.get('http://' + this.location.host + '/api/category/' + categoryId);
  }
}
