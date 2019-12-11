import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WebMainComponent } from './web-main.component';

describe('MainComponent', () => {
  let component: WebMainComponent;
  let fixture: ComponentFixture<WebMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WebMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WebMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
