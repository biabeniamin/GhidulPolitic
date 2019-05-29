import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { CandidateService } from '../CandidateService';
import { Candidate } from '../Models/Candidate';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {

public userId:number = 3;
public candidate:Candidate ;
public image:string="http://biabeniamin.go.ro/GhidImages/3.jpg";
  constructor(private http:HttpClient, 
    private candidateService : CandidateService,
    private cookieService: CookieService) { 

      this.candidate=CandidateService.GetDefaultCandidate();
      let userId = this.cookieService.get("userId");
      if(userId!=null)
      {
        console.log("getting candidate");
        candidateService.GetCandidatesByCandidateId(userId).subscribe((data) => {
          console.log("candidate obtained");
          console.log(data);
          this.candidate = data[0];
          this.image="http://biabeniamin.go.ro/GhidImages/"+this.candidate.candidateId+".jpg";
        });
      }

    }

  ngOnInit() {
  }

}
