import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  firstname: string = "";
  lastname: string = "";
  username: string = "";
  password: string = "";
  password2: string = "";
  message: string = "";

  submitted: boolean = false;

  height: Number = window.innerHeight;

  constructor(private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  register() {
    if (!this.username) {
      return;
    }

    if (!this.password) {
      return;
    }

    if (this.password != this.password2){
      this.message = "Passwords didn't match! Please try again!"
      return;
    }

    this.auth.register(
      this.firstname,
      this.lastname,
      this.username,
      this.password,
    ).subscribe(
      response => {
        console.log(response);
        if (response === null) {
          this.message = "This Didn't Work. Please Try Again!"
        } else {
          this.router.navigate(['']); //need to route somewhere? dashboard maybe
        }
      },
      err => {
        console.error("Error: " + err);
      },
      () => {
        console.log("Complete");
      }
    )
  }
}
