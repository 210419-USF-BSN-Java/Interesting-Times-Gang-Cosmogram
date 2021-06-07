import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Image } from '../models/image';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {
  configUrl = 'http://localhost:8080/';
  constructor(private http: HttpClient) { }
  getImage(extension: string) {
    return this.http.get<Array<Image>>(this.configUrl + 'image/' + extension);
  }
}
