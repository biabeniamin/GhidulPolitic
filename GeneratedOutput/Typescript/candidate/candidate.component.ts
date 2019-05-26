import { Component, OnInit } from '@angular/core';
import { CandidateService } from '../CandidateService'
import {HttpClient} from '@angular/common/http';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
selector: 'app-candidate',
templateUrl: './candidate.component.html',
styleUrls: ['./candidate.component.css']
})
export class CandidateComponent implements OnInit
{
	
	constructor(private http:HttpClient, 
		private candidateService : CandidateService
	)
	{
	
	}
	
	ngOnInit()
	{
	
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
		console.log(candidate);
		this.candidateService.AddCandidate(candidate);
	}
	

}

