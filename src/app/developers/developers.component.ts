import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CandidateService } from '../CandidateService';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-developers',
  templateUrl: './developers.component.html',
  styleUrls: ['./developers.component.css']
})
export class DevelopersComponent implements OnInit {

  constructor(private http:HttpClient, 
    public candidateService : CandidateService,
    private cookieService: CookieService,
    private router: Router) { }

  ngOnInit() {
  }

  explore(id)
  {
    console.log(id);
    this.cookieService.set( 'selectedUserId', id.toString() );
    this.router.navigate(['/details']);
  }

}
