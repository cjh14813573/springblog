import { Component, OnInit } from '@angular/core';
import { CommonResponse } from 'src/app/util/commonResponse';
import { CategoryService } from 'src/app/service/category.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-category-main',
  templateUrl: './category-main.component.html',
  styleUrls: ['./category-main.component.css']
})
export class CategoryMainComponent implements OnInit {

  category;

  categoryId;

  constructor(
    private categoryService: CategoryService,
    private route: ActivatedRoute,
  ) {
    this.route.paramMap.subscribe(params => {
      this.categoryId = +params.get('categoryId');
      this.categoryService.getCategoryById(this.categoryId).subscribe((data: CommonResponse) => {
        if (data.status === 1) {
          this.category = data.responseBody;
        }
      });
    });
  }

  ngOnInit() {
  }

}
