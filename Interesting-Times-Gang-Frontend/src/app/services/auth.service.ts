import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url: string = "http://localhost:8080/auth";

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<User> {
    // this is where they'll connect to the application
    let loginInfo = {
      username: username,
      password: password,
    }

    return this.http.request(this.url, loginInfo).pipe(
      map(response => response as User)
    );
  }
}


