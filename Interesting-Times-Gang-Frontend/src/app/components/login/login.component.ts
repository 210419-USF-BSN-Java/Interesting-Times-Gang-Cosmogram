import { Component, OnInit } from '@angular/core';
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

  constructor(private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  signIn() {
    this.auth.login(this.username, this.password).subscribe(
      response => {
        // this.router.navigate('dashboard') need to route somewhere? dashboard maybe


      },
      err => {
        console.error("Error");
      },
      () => {
        console.log("Complete");
      }
    )
  }
}
