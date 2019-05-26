import {HttpClient} from '@angular/common/http';
import { ServerUrl } from './ServerUrl'
import { Injectable } from '@angular/core';
import { Partid } from '../app/Models/Partid'

@Injectable({
    providedIn : 'root'
})
export class PartidService
{
	public partids : Partid[];
	GetPartids()
	{
		return this.http.get<Partid[]>(ServerUrl.GetUrl()  + "Partids.php?cmd=getPartids").subscribe(data =>
		{
			this.partids = data;
		});
	}
	
	GetLastPartid()
	{
		return this.http.get<Partid[]>(ServerUrl.GetUrl()  + "Partids.php?cmd=getPartids");
	}
	
	static GetDefaultPartid()
	{
		return {
		partidId : 0,
		nume : 'Test',
		pozitie : 0,
		creationTime : '2000-01-01 00:00:00'
		};
	}
	
	constructor(private http:HttpClient)
	{
		this.partids = [PartidService.GetDefaultPartid()];
		this.GetPartids();
	
	}
	
	AddPartid(partid)
	{
		return this.http.post<Partid>(ServerUrl.GetUrl()  + "Partids.php?cmd=addPartid", partid).subscribe(partid =>
		{
			console.log(partid);
			if(0 != partid.partidId)
			{
				this.partids.push(partid)
			}
		});
	}
	
	UpdatePartid(partid)
	{
		return this.http.put<Partid>(ServerUrl.GetUrl()  + "Partids.php?cmd=updatePartid", partid).subscribe(partid =>
		{
			console.log(partid);
			return partid;
		});
	}
	
	DeletePartid(partid)
	{
		return this.http.delete<Partid>(ServerUrl.GetUrl()  + "Partids.php?cmd=deletePartid&partidId=" +  partid.partidId, ).subscribe(partid =>
		{
			console.log(partid);
			return partid;
		});
	}
	
	GetPartidsByPartidId(partidId)
	{
		return this.http.get<Partid[]>(ServerUrl.GetUrl()  + `Partids.php?cmd=getPartidsByPartidId&partidId=${partidId}`);
	}
	

}
