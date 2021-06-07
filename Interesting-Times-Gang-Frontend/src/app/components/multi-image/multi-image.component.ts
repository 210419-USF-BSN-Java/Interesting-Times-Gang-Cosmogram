import { Component, Input } from '@angular/core';
import { Image } from '../../models/image';

@Component({
  selector: 'app-multi-image',
  templateUrl: './multi-image.component.html',
  styleUrls: ['./multi-image.component.css']
})
export class MultiImageComponent {
  @Input() imageArray?= Array<Image>();
  @Input() albumTitle?: string;
  currentImg?: Image;
  selectImg(image: Image) {
    this.currentImg = image;
    console.log(this.currentImg);
  }
}
