import { Component, OnInit } from '@angular/core';
import { Image } from '../../models/image';
import { ApiServiceService } from '../../services/api-service.service';

@Component({
  selector: 'app-search-image-tag',
  templateUrl: './search-image-tag.component.html',
  styleUrls: ['./search-image-tag.component.css']
})
export class SearchImageTagComponent implements OnInit {
  tag = '';
  imgObservable!: Array<Image>;
  imgA?: Array<Image>;
  ngOnInit() { }
  constructor(private apiService: ApiServiceService) { }
  search() {
    // this.apiService.getImage("tag/?tagName=" + this.tag).subscribe(response => {
    console.log(this.tag);

    // })
  }
}
