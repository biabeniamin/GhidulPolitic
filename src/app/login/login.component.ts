import { Component, OnInit } from '@angular/core';
import { CandidateService } from '../CandidateService';
import { HttpClient } from '@angular/common/http';
import { forEach } from '@angular/router/src/utils/collection';
import { Candidate } from '../Models/Candidate'
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private http:HttpClient, 
    private candidateService : CandidateService,
    private cookieService: CookieService,
    private router: Router) { }

  ngOnInit() {
  }

  loginCandidate(event)
	{
		event.preventDefault();
		const target = event.target;
		let candidate = CandidateService.GetDefaultCandidate();
		candidate.email = target.querySelector('#Email').value;
		candidate.password = target.querySelector('#Password').value;
    console.log(candidate);
    for(let cand of this.candidateService.candidates)
    {
      console.log(cand);
      if(cand.email == candidate.email && cand.password == candidate.password)
      {
        console.log(cand);
        this.cookieService.set( 'userId', cand.candidateId.toString() );
        this.router.navigate(['/update']);
      }
    }
    
		//this.candidateService.AddCandidate(candidate);
	}

}
