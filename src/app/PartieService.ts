import {HttpClient} from '@angular/common/http';
import { ServerUrl } from './ServerUrl'
import { Injectable } from '@angular/core';
import { Partie } from '../app/Models/Partie'

@Injectable({
    providedIn : 'root'
})
export class PartieService
{
	public parties : Partie[];
	GetParties()
	{
		return this.http.get<Partie[]>(ServerUrl.GetUrl()  + "Parties.php?cmd=getParties").subscribe(data =>
		{
			this.parties = data;
		});
	}
	
	GetLastPartie()
	{
		return this.http.get<Partie[]>(ServerUrl.GetUrl()  + "Parties.php?cmd=getParties");
	}
	
	static GetDefaultPartie()
	{
		return {
		partieId : 0,
		name : 'Test',
		position : 0,
		creationTime : '2000-01-01 00:00:00'
		};
	}
	
	constructor(private http:HttpClient)
	{
		this.parties = [PartieService.GetDefaultPartie()];
		this.GetParties();
	
	}
	
	AddPartie(partie)
	{
		return this.http.post<Partie>(ServerUrl.GetUrl()  + "Parties.php?cmd=addPartie", partie).subscribe(partie =>
		{
			console.log(partie);
			if(0 != partie.partieId)
			{
				this.parties.push(partie)
			}
		});
	}
	
	UpdatePartie(partie)
	{
		return this.http.put<Partie>(ServerUrl.GetUrl()  + "Parties.php?cmd=updatePartie", partie).subscribe(partie =>
		{
			console.log(partie);
			return partie;
		});
	}
	
	DeletePartie(partie)
	{
		return this.http.delete<Partie>(ServerUrl.GetUrl()  + "Parties.php?cmd=deletePartie&partieId=" +  partie.partieId, ).subscribe(partie =>
		{
			console.log(partie);
			return partie;
		});
	}
	
	GetPartiesByPartieId(partieId)
	{
		return this.http.get<Partie[]>(ServerUrl.GetUrl()  + `Parties.php?cmd=getPartiesByPartieId&partieId=${partieId}`);
	}
	

}
