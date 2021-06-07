import { Component, OnInit } from '@angular/core';
import { Image } from '../../models/image';
import { ApiServiceService } from '../../services/api-service.service';

@Component({
  selector: 'app-search-image-range',
  templateUrl: './search-image-range.component.html',
  styleUrls: ['./search-image-range.component.css']
})
export class SearchImageRangeComponent implements OnInit {
  ngOnInit(): void {
  }
  date1Str = '';
  date2Str = '';
  imgObservable!: Array<Image>;
  imgA?: Array<Image>;

  constructor(private apiService: ApiServiceService) { }
  search() {
    if (this.date1Str && this.date2Str) {
      let url: string = 'range/?userId=2&startDate=' + this.date1Str + '&endDate=' + this.date2Str;
      this.apiService.getImage(url)
        .subscribe((data: Array<Image>) => {
          this.imgObservable = data;
          this.imgA = this.imgObservable;
        });
    }
  }
}
