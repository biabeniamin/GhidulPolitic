import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {

public userId:number = 3;
public image:string="http://biabeniamin.go.ro/GhidImages/3.jpg";
  constructor() { }

  ngOnInit() {
  }

}
