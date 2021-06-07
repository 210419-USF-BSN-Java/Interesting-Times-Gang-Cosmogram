import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchImageDateComponent } from './search-image-date.component';

describe('SearchImageDateComponent', () => {
  let component: SearchImageDateComponent;
  let fixture: ComponentFixture<SearchImageDateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchImageDateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchImageDateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
