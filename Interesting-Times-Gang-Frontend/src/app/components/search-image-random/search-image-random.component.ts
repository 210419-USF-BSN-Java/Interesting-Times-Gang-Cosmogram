import { Component, OnInit } from '@angular/core';
import { Image } from '../../models/image';
import { ApiServiceService } from '../../services/api-service.service';

@Component({
  selector: 'app-search-image-random',
  templateUrl: './search-image-random.component.html',
  styleUrls: ['./search-image-random.component.css']
})
export class SearchImageRandomComponent implements OnInit {
  ngOnInit(): void {
    this.random();

  }
  imgObservable!: Array<Image>;
  img?: Image;

  constructor(private apiService: ApiServiceService) { }
  random() {
    let url: string = 'random/?userId=2';
    this.apiService.getImage(url).subscribe((data: Array<Image>) => {
      this.imgObservable = data;
      this.img = this.imgObservable[0];
    });
  }

}
