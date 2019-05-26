import { Component, OnInit } from '@angular/core';
import { CandidatService } from '../CandidatService'
import {HttpClient} from '@angular/common/http';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
selector: 'app-candidat',
templateUrl: './candidat.component.html',
styleUrls: ['./candidat.component.css']
})
export class CandidatComponent implements OnInit
{
	
	constructor(private http:HttpClient, 
		private candidatService : CandidatService
	)
	{
	
	}
	
	ngOnInit()
	{
	
	}
	
	addCandidat(event)
	{
		event.preventDefault();
		const target = event.target;
		let candidat = CandidatService.GetDefaultCandidat();
		candidat.nume = target.querySelector('#Nume').value;
		candidat.descriere = target.querySelector('#Descriere').value;
		candidat.functie = target.querySelector('#Functie').value;
		console.log(candidat);
		this.candidatService.AddCandidat(candidat);
	}
	

}

