import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  // styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  error: string | null = null;
  constructor(private authService: AuthService) {}

  //this method runs every time component is created and initialized
  ngOnInit() {
    //timeout is variable in Auth
    //.subscribe() is a method on the Observable type
    this.authService.timeout.subscribe((isTimeOut) => {
      if (isTimeOut)
        this.error = 'Your session is expired. Please Login again!';
    });
    // if not TimeOut we call autoLogin() Methof of Auth
    this.authService.autoLogin();
  }

  handleError() {
    this.error = null;
  }
}

//Observable in Angular is a feature 
//that provides support for delivering messages between different parts of your single-page application