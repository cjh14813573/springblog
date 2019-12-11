import { Injectable } from '@angular/core';
import { CommonResponse } from '../util/commonResponse';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PageService {

  constructor(
    private http: HttpClient,
  ) { }

  getNavData(){
    return this.http.get('http://localhost:8080/api/nav');
  }

  getPage(id){
    return this.http.get('http://localhost:8080/api/page/' + id);
  }
}
