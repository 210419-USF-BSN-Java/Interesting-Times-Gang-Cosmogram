import { Component, Input, OnInit } from '@angular/core';
import { Album } from 'src/app/models/album';
import { Image } from '../../models/image';
import { ApiServiceService } from '../../services/api-service.service';
import { Tool } from '../tool-components/tool';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  @Input() currentToolDashboard?: Tool;
  @Input() currentComponent: string = "default"; //sets default to single image component
  @Input() currentComponentAlbum?: Album;
  currentComponentImageArray?: Image[];

  constructor(private apiService: ApiServiceService) { }
  currentDayImg?: Image;
  imgObservable!: Array<Image>;
  extension = '?userId=' + sessionStorage.getItem("userId");

  img?: Image;
  imgA!: Array<Image>;

  url = 'http://localhost:8080/image/random/?userId=2';
  ngOnInit(): void {
    this.apiService.getImage(this.extension)
      .subscribe((data: Array<Image>) => {
        this.imgObservable = data;
        this.currentDayImg = this.imgObservable[0];
      });
  }

  dashboardAcceptTool(tool: Tool): void {
    this.currentToolDashboard = tool;
    this.currentComponent = tool.title || "default";
    tool.album ? this.currentComponentAlbum = tool.album : [];
    if (this.currentComponentAlbum) {
      let imageArray: Image[] = [];

      console.log("Dashboard :" + tool.album);
      console.log(tool.album);
      console.log(tool.album?.imageDates);

      for (let thisDate of this.currentComponentAlbum.imageDates) {
        let apiUrl: string = "/date/?imageDate=" + thisDate + "&userId=" + sessionStorage.getItem("userId");
        this.apiService.getImage(apiUrl).subscribe((data: Array<Image>) => {
          imageArray.push(data[0]);
        });
      }
      this.currentComponentImageArray = imageArray;
    }
  }






}