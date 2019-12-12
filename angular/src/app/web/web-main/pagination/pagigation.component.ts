import { Component, OnInit, Input, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent implements OnInit {

  @Input() pageResponse;


  @Output() goPrevious = new EventEmitter();
  @Output() goNext = new EventEmitter();
  @Output() goPage = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {
  }

  totalPages() {
    let pages: number[] = [];
    for (let i = 0; i < this.pageResponse.totalPages; i++) {
      pages.push(i);
    }
    return pages;
  }

}
