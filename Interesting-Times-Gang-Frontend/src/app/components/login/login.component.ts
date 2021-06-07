import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string = "";
  password: string = "";
  message: string = "";

  /* Style properties */
  loginHeight: Number = window.innerHeight;

  constructor(private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  signIn() {
    this.auth.login(this.username, this.password).subscribe(
      // observer
      response => {
        // console.log(response);
        if (response === null) {
          this.message = "Didn't work. Please Try Again!"
        } else {
          var num = new Number(10);
          num = Number(response.id);
          console.log("signin method: " + response);
          sessionStorage.setItem("userId", response.id.toString());
          this.router.navigate(['dashboard']); //need to route somewhere? dashboard maybe
        }
      },
      err => {
        console.error(err);
      },
      () => {
        console.log("Complete");
      }
    )
  }
}
