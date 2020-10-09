import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ClientService} from "../../services/client.service";
import {AuthenticationService} from "../../services/authentication.service";
import {Bnbecome} from "../../services/bnbecome.service";

@Component({
  selector: 'app-accueil-cv',
  templateUrl: './accueil-cv.component.html',
  styleUrls: ['./accueil-cv.component.css']
})
export class AccueilCvComponent implements OnInit {
  public userId: number | any;
  public clientConnect:boolean;
  constructor(private http: HttpClient,private clientService:ClientService, private userConnect:AuthenticationService
    ,private bnbecome:Bnbecome) {
    if (userConnect.userAuthenticated){
      this.clientConnect=this.userConnect.userAuthenticated;
      this.userId=this.userConnect.userAuthenticated.id;}
  }

  ngOnInit(): void {

  }

}
