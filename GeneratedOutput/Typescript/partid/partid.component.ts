import { Component, OnInit } from '@angular/core';
import { PartidService } from '../PartidService'
import {HttpClient} from '@angular/common/http';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
selector: 'app-partid',
templateUrl: './partid.component.html',
styleUrls: ['./partid.component.css']
})
export class PartidComponent implements OnInit
{
	
	constructor(private http:HttpClient, 
		private partidService : PartidService
	)
	{
	
	}
	
	ngOnInit()
	{
	
	}
	
	addPartid(event)
	{
		event.preventDefault();
		const target = event.target;
		let partid = PartidService.GetDefaultPartid();
		partid.nume = target.querySelector('#Nume').value;
		partid.pozitie = target.querySelector('#Pozitie').value;
		console.log(partid);
		this.partidService.AddPartid(partid);
	}
	

}

