import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchImageRandomComponent } from './search-image-random.component';

describe('SearchImageRandomComponent', () => {
  let component: SearchImageRandomComponent;
  let fixture: ComponentFixture<SearchImageRandomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchImageRandomComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchImageRandomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
