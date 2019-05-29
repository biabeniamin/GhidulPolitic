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
import { UploadComponent } from './upload/upload.component';
import { FileSelectDirective } from 'ng2-file-upload';
import { FormsModule } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { UpdateComponent } from './update/update.component';
import { DetailsComponent } from './details/details.component';

// app.module.ts



@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    LoginComponent,
    NavbarComponent,
    RegisterComponent,
    DevelopersComponent,
    UploadComponent,
    FileSelectDirective,
    UpdateComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
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
    path: 'upload',
    component: UploadComponent,
 },
 {
  path: 'register',
  component: RegisterComponent,
}
{
  path: 'update',
  component: UpdateComponent,
},
{
  path: 'details',
  component: DetailsComponent,
}
 ,
   {
    path: 'developers',
    component: DevelopersComponent,
 },
   ])
  ],
  providers: [CookieService],
  bootstrap: [AppComponent],
  

})
export class AppModule { }
