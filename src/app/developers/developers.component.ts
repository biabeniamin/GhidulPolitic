import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CandidateService } from '../CandidateService';

@Component({
  selector: 'app-developers',
  templateUrl: './developers.component.html',
  styleUrls: ['./developers.component.css']
})
export class DevelopersComponent implements OnInit {

  constructor(private http:HttpClient, 
		public candidateService : CandidateService) { }

  ngOnInit() {
  }

}
