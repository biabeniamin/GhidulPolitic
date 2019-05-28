import {HttpClient} from '@angular/common/http';
import { ServerUrl } from './ServerUrl'
import { Injectable } from '@angular/core';
import { Candidate } from '../app/Models/Candidate'

@Injectable({
    providedIn : 'root'
})
export class CandidateService
{
	public candidates : Candidate[];
	GetCandidates()
	{
		console.log(ServerUrl.GetUrl())
		return this.http.get<Candidate[]>(ServerUrl.GetUrl()  + "candidate").subscribe(data =>
			 
		{
			console.log(data);
			this.candidates = data;
		});
	}
	
	GetLastCandidate()
	{
		return this.http.get<Candidate[]>(ServerUrl.GetUrl()  + "Candidates.php?cmd=getCandidates");
	}
	
	static GetDefaultCandidate()
	{
		return {
		candidateId : 0,
		name : 'Test',
		email : 'Test',
		password : 'Test',
		description : 'Test',
		role : 'Test',
		creationTime : '2000-01-01 00:00:00'
		};
	}
	
	constructor(private http:HttpClient)
	{
		this.candidates = [CandidateService.GetDefaultCandidate()];
		this.GetCandidates();
	
	}
	
	AddCandidate(candidate)
	{
		return this.http.post<Candidate>(ServerUrl.GetUrl()  + "candidate", candidate).subscribe(candidate =>
		{
		});
	}
	
	UpdateCandidate(candidate)
	{
		return this.http.put<Candidate>(ServerUrl.GetUrl()  + "Candidates.php?cmd=updateCandidate", candidate).subscribe(candidate =>
		{
			console.log(candidate);
			return candidate;
		});
	}
	
	DeleteCandidate(candidate)
	{
		return this.http.delete<Candidate>(ServerUrl.GetUrl()  + "Candidates.php?cmd=deleteCandidate&candidateId=" +  candidate.candidateId, ).subscribe(candidate =>
		{
			console.log(candidate);
			return candidate;
		});
	}
	
	GetCandidatesByCandidateId(candidateId)
	{
		return this.http.get<Candidate[]>(ServerUrl.GetUrl()  + `Candidates.php?cmd=getCandidatesByCandidateId&candidateId=${candidateId}`);
	}
	

}
