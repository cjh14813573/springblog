import { SortResponse } from './pageable/sort/sortResponse';
import { PageableResponse } from './pageable/pageableResponse';

export class PageResponse {


  content: [];
  pageable: PageableResponse;
  last: boolean;
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
  sort: SortResponse;
  first: boolean;
  numberOfElements: number;
  empty: boolean;



  constructor() {
  }
}
