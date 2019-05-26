import {HttpClient} from '@angular/common/http';
import { ServerUrl } from './ServerUrl'
import { Injectable } from '@angular/core';
import { Candidat } from '../app/Models/Candidat'

@Injectable({
    providedIn : 'root'
})
export class CandidatService
{
	public candidats : Candidat[];
	GetCandidats()
	{
		return this.http.get<Candidat[]>(ServerUrl.GetUrl()  + "Candidats.php?cmd=getCandidats").subscribe(data =>
		{
			this.candidats = data;
		});
	}
	
	GetLastCandidat()
	{
		return this.http.get<Candidat[]>(ServerUrl.GetUrl()  + "Candidats.php?cmd=getCandidats");
	}
	
	static GetDefaultCandidat()
	{
		return {
		candidatId : 0,
		nume : 'Test',
		descriere : 'Test',
		functie : 'Test',
		creationTime : '2000-01-01 00:00:00'
		};
	}
	
	constructor(private http:HttpClient)
	{
		this.candidats = [CandidatService.GetDefaultCandidat()];
		this.GetCandidats();
	
	}
	
	AddCandidat(candidat)
	{
		return this.http.post<Candidat>(ServerUrl.GetUrl()  + "Candidats.php?cmd=addCandidat", candidat).subscribe(candidat =>
		{
			console.log(candidat);
			if(0 != candidat.candidatId)
			{
				this.candidats.push(candidat)
			}
		});
	}
	
	UpdateCandidat(candidat)
	{
		return this.http.put<Candidat>(ServerUrl.GetUrl()  + "Candidats.php?cmd=updateCandidat", candidat).subscribe(candidat =>
		{
			console.log(candidat);
			return candidat;
		});
	}
	
	DeleteCandidat(candidat)
	{
		return this.http.delete<Candidat>(ServerUrl.GetUrl()  + "Candidats.php?cmd=deleteCandidat&candidatId=" +  candidat.candidatId, ).subscribe(candidat =>
		{
			console.log(candidat);
			return candidat;
		});
	}
	
	GetCandidatsByCandidatId(candidatId)
	{
		return this.http.get<Candidat[]>(ServerUrl.GetUrl()  + `Candidats.php?cmd=getCandidatsByCandidatId&candidatId=${candidatId}`);
	}
	

}
