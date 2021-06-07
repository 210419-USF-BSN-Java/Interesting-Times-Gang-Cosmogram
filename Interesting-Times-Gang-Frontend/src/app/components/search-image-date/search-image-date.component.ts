import { Component, OnInit } from '@angular/core';
import { Image } from '../../models/image';
import { ApiServiceService } from '../../services/api-service.service';

@Component({
  selector: 'app-search-image-date',
  templateUrl: './search-image-date.component.html',
  styleUrls: ['./search-image-date.component.css']
})
export class SearchImageDateComponent implements OnInit {
  ngOnInit(): void {
  }
  dateStr = '';
  imgObservable!: Array<Image>;
  img?: Image;

  constructor(private apiService: ApiServiceService) { }

  search() {
    if (this.dateStr) {
      let url: string = 'date/?userId=2&imageDate=' + this.dateStr;
      this.apiService.getImage(url).subscribe((data: Array<Image>) => {
        this.imgObservable = data;
        this.img = this.imgObservable[0];
      });
    }
  }
}
