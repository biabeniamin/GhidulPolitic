import { Component, OnInit } from '@angular/core';
import { CandidateService } from '../CandidateService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

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
		//this.candidateService.AddCandidate(candidate);
	}

}
