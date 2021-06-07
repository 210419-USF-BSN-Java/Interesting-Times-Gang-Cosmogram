import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map, tap } from 'rxjs/operators';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(
    username: string,
    password: string
  ): Observable<User> {
    // this is where they'll connect to the application
    let loginInfo = {
      username: username,
      password: password,
    }

    return this.http.post(
      "http://localhost:8080/user/login",
      loginInfo,
    ).pipe(
      // tap(response => console.log("post method: " + response)),
      map(response => response as User)
    )

  }

  register(
    firstname: string,
    lastname: string,
    username: string,
    password: string,
    roleId: string = "1",
  ): Observable<User> {

    let registerInfo = {
      username: username,
      password: password,
      firstName: firstname,
      lastName: lastname,
      roleId: roleId,
    }

    return this.http.post(
      "http://localhost:8080/user/register",
      registerInfo
    ).pipe(map(response => response as User))
  }

  updateInfo(
    user: User,
  ): Observable<any> {
    return this.http.post(
      "http://localhost:8080/user/update",
      user
    ).pipe(
      tap(response => console.log(response)),
      map(response => response.toString())
    )
  }

  getUserInfo(): Observable<User> {

    return this.http.get(
      "http://localhost:8080/user/view-info",
      {
        headers: {
          "Authorization": sessionStorage.getItem("user") || ""
        }
      }
    ).pipe(
      map(response => response as User)
    )
  }
}


function tag(arg0: void): import("rxjs").OperatorFunction<Object, unknown> {
  throw new Error('Function not implemented.');
}

