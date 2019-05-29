import { Component, OnInit } from '@angular/core';
import { Candidate } from '../Models/Candidate';
import { CandidateService } from '../CandidateService';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  public candidate:Candidate ;
  public name : string="asfgas";
  constructor() { 
    this.candidate=CandidateService.GetDefaultCandidate();
    
  }

  ngOnInit() {
  }

  updateCandidate(event)
	{
		event.preventDefault();
    const target = event.target;
    console.log(this.candidate);
		/*let candidate = CandidateService.GetDefaultCandidate();
		candidate.name = target.querySelector('#Name').value;
		candidate.email = target.querySelector('#Email').value;
		candidate.password = target.querySelector('#Password').value;
		candidate.description = target.querySelector('#Description').value;
		candidate.role = target.querySelector('#Role').value;
		console.log(candidate);
		this.candidateService.AddCandidate(candidate);*/
	}

}
