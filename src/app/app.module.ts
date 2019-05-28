import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterComponent } from './register/register.component';
import { DevelopersComponent } from './developers/developers.component';
import { HttpClientModule } from '@angular/common/http';

// app.module.ts



@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    LoginComponent,
    NavbarComponent,
    RegisterComponent,
    DevelopersComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    RouterModule.forRoot([
      {
        path: 'main',
        component: MainComponent,
     },
     {
      path: 'login',
      component: LoginComponent,
   },
   {
    path: 'register',
    component: RegisterComponent,
 }
 ,
   {
    path: 'developers',
    component: DevelopersComponent,
 },
   ])
  ],
  providers: [],
  bootstrap: [AppComponent],
  

})
export class AppModule { }
