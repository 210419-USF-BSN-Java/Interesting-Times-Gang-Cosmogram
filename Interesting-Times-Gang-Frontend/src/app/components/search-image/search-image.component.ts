import { Component } from '@angular/core';
import { Image } from '../../models/image';
import { ApiServiceService } from '../../services/api-service.service';

@Component({
  selector: 'app-search-image',
  templateUrl: './search-image.component.html',
  styleUrls: ['./search-image.component.css']
})
export class SearchImageComponent {
  view: number = 1;
  tag = '';
  dateStr = '';
  date1Str = '';
  date2Str = '';
  date?: Date;
  date1?: Date;
  date2?: Date;
  imgObservable!: Array<Image>;
  img?: Image;
  imgA?: Array<Image>;

  constructor(private apiService: ApiServiceService) { }
  changeView(num: number) {
    this.view = num;
    console.log(this.view);
  }
  search() {
    switch (this.view) {
      case 1:
        console.log(this.tag);

        break;
      case 2:
        if (this.dateStr) {
          let url: string = 'date/?userId=2&imageDate=' + this.dateStr;
          this.apiService.getImage(url).subscribe((data: Array<Image>) => this.imgObservable = data);
          this.img = this.imgObservable[0];
        }
        break;
      case 3:
        if (this.date1Str && this.date2Str) {
          let url: string = 'range/?userId=2&startDate=' + this.date1Str + '&endDate=' + this.date2Str;
          this.apiService.getImage(url)
            .subscribe((data: Array<Image>) => this.imgObservable = data);
          this.imgA = this.imgObservable;
        }
        break;
    }
  }
}