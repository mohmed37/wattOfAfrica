import {Component, Input, OnInit} from '@angular/core';
import {AuthenticationService} from "../services/authentication.service";
import {ClientService} from "../services/client.service";
import {QuestionnairesModel} from "../model/questionnaires.model";
import {Observable} from "rxjs";
import {PhotoLangageModel} from "../model/photoLangage.model";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-bndream',
  templateUrl: './bndream.component.html',
  styleUrls: ['./bndream.component.css']
})
export class BndreamComponent implements OnInit {

  constructor(public authService:AuthenticationService,private httpClient: HttpClient,private serviceClient:ClientService) { }

  ngOnInit(): void {
  }



}
