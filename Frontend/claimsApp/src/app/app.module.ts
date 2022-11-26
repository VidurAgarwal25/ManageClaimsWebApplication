// this holds all the component we are creating 
//This is where we glue our component and all the modules that are required for our project to work.

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthComponent } from './auth/auth.component';
import { LoadingSpinnerComponent } from './shared/loading-spinner/loading-spinner.component';
import { AuthInterceptorService } from './auth/auth-interceptor.service';
import { AlertComponent } from './shared/alert/alert.component';
import { ClaimsComponent } from './claims/claims.component';
import { ClaimsFormComponent } from './claims/claims-form/claims-form.component';
import { ClaimsResultComponent } from './claims/claims-result/claims-result.component';
import { SubmitClaimFormComponent } from './claims/submit-claim-form/submit-claim-form.component';


@NgModule({
  //Declarations is where we put all the components in our application. 
  //we need to declare all the components using the declarations block.
  declarations: [ 
    AppComponent,
    HeaderComponent,
    HomeComponent,
    AuthComponent,
    LoadingSpinnerComponent,
    AlertComponent,
    ClaimsComponent,
    ClaimsFormComponent,
    ClaimsResultComponent,
    SubmitClaimFormComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  // imports will import a external modules that are required for our application to work
  providers: [
    {
      //defines the set of injectable objects that are available in the injector of this module
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
  //Bootstrap is where we mention which is the starting point of our application.
})
export class AppModule {}
