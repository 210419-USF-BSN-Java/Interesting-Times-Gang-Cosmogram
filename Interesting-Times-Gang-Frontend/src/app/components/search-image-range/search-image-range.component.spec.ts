import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchImageRangeComponent } from './search-image-range.component';

describe('SearchImageRangeComponent', () => {
  let component: SearchImageRangeComponent;
  let fixture: ComponentFixture<SearchImageRangeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchImageRangeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchImageRangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
