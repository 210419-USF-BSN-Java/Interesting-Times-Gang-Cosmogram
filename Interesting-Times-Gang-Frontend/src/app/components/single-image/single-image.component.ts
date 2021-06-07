import { Component, OnChanges, Input } from '@angular/core';
import { tags, albums, DailyImage } from '../../images';
import { Image } from '../../models/image';
import { HttpClient } from '@angular/common/http';
import { Tool } from '../tool-components/tool';
import { albumsTools } from '../tool-components/albumsTools';


@Component({
  selector: 'app-single-image',
  templateUrl: './single-image.component.html',
  styleUrls: ['./single-image.component.css'],
})

export class SingleImageComponent implements OnChanges {
  @Input() image?: Image;
  albums = albums;
  tags = tags;
  hoveredRating: number = 0;
  finalRating: number = 0;
  alertStr: string = "";
  dropdownAlbum: string = "";
  dropdownTag: string = "";
  userRole: number = 2;
  albumsToolbox: Tool[] = albumsTools;



  constructor(private http: HttpClient) { }

  mouseEnter(num: number) {
    if (this.finalRating == 0)
      this.hoveredRating = num;
    else
      this.hoveredRating = this.finalRating;
  }
  resetHoveredRating() {
    if (this.finalRating == 0)
      this.hoveredRating = 0;
    else
      this.hoveredRating = this.finalRating;
  }
  setFinalRating(num: number) {
    this.finalRating = num;
    this.alertStr = `You have given <b>${this.image?.title}</b> a <b>${this.finalRating}-star rating</b>.`;
  }
  addToAlbum(album: string) {
    this.alertStr = `You have added <b>${this.image?.title}</b> to <b>${album}</b>.`;
  }
  addTag(tag: string) {
    this.alertStr = `You have tagged <b>${this.image?.title}</b> as <b>${tag}</b>.`;
  }
  showAlbum() {
    this.dropdownAlbum = 'block';
  }
  hideAlbum() {
    this.dropdownAlbum = 'none';
  }
  showTag() {
    this.dropdownTag = 'block';
  }
  hideTag() {
    this.dropdownTag = 'none';
  }
  ngOnChanges() {
    this.hoveredRating = 0;
    this.finalRating = 0;
    this.alertStr = "";
    console.log(this.image);
    console.log(this.image?.date);
  }
}