import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CandidateService } from '../CandidateService';
import { PartieService } from '../PartieService';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private http:HttpClient, 
		private candidateService : CandidateService,
		public partieService: PartieService) { }

  ngOnInit() {
  }

  addCandidate(event)
	{
		event.preventDefault();
		const target = event.target;
		let candidate = CandidateService.GetDefaultCandidate();
		candidate.name = target.querySelector('#Name').value;
		candidate.email = target.querySelector('#Email').value;
		candidate.password = target.querySelector('#Password').value;
		candidate.description = target.querySelector('#Description').value;
		candidate.role = target.querySelector('#Role').value;
		candidate.partieId = target.querySelector('#UserIdDropDown').value;
		console.log(candidate);
		this.candidateService.AddCandidate(candidate);
	}


}
