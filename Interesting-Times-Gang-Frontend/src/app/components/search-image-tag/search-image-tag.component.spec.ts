import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchImageTagComponent } from './search-image-tag.component';

describe('SearchImageTagComponent', () => {
  let component: SearchImageTagComponent;
  let fixture: ComponentFixture<SearchImageTagComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchImageTagComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchImageTagComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
