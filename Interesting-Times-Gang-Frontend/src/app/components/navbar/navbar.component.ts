import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Album } from 'src/app/models/album';
import { albumsTools } from '../tool-components/albumsTools';
import { Tool } from '../tool-components/tool';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  showToolbar: boolean = false;
  title?: string = "Welcome";
  @Input() currentComponent: string = "";
  // @Output() emitComponentName = new EventEmitter<string>();
  albums?: Album[];

  @Input() selectedToolNav?: Tool;
  @Output() giveDashboardTool = new EventEmitter<Tool>();


  constructor(private http: HttpClient) { }

  ngOnInit(): void {

    albumsTools.forEach(a => albumsTools.pop());
    let userAlbumsUrl = ("http://localhost:8080/album/?userId=" + sessionStorage.getItem("userId"));
    this.http.get<Album[]>(userAlbumsUrl).subscribe(
      albums => {
        // console.log(albums); //albums is an array!!! remember this shit
        // this.albums = albums;

        for (let a of albums) {
          let tool: Tool = {
            title: a.album.albumName,
            album: a,
          };
          // console.log("Storing data: " + tool);
          // console.log(tool);
          albumsTools.push(tool);
          // console.log("Check document: ");
          // console.log(albumsTools);
        }
      }
    );
  }

  toggleToolbar(): void {
    if (this.showToolbar) {
      this.showToolbar = false;
    } else {
      this.showToolbar = true;
    }
  }

  setTitle(title: string): void {
    this.title = title;
    // this.emitComponentName.emit(title);
  }

  acceptNavsTool(tool: Tool): void {
    this.selectedToolNav = tool;
    this.giveDashboardTool.emit(this.selectedToolNav);
  }
}
