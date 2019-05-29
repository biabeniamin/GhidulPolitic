import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public userId:number = 1;

  constructor(private cookieService: CookieService) { 
    this.userId = Number(this.cookieService.get("userId"));
  }

  ngOnInit() {
  }

}
