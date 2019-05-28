import { Component, OnInit } from '@angular/core';
import { PartieService } from '../PartieService'
import {HttpClient} from '@angular/common/http';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
selector: 'app-partie',
templateUrl: './partie.component.html',
styleUrls: ['./partie.component.css']
})
export class PartieComponent implements OnInit
{
	
	constructor(private http:HttpClient, 
		private partieService : PartieService
	)
	{
	
	}
	
	ngOnInit()
	{
	
	}
	
	addPartie(event)
	{
		event.preventDefault();
		const target = event.target;
		let partie = PartieService.GetDefaultPartie();
		partie.name = target.querySelector('#Name').value;
		partie.position = target.querySelector('#Position').value;
		console.log(partie);
		this.partieService.AddPartie(partie);
	}
	

}

