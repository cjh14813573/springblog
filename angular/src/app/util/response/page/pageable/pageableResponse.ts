import { SortResponse } from './sort/sortResponse';

export class PageableResponse {

  sort: SortResponse;
  offset: number;
  pageSize: number;
  unpaged: boolean;
  paged: boolean;


  constructor() {
  }
}
