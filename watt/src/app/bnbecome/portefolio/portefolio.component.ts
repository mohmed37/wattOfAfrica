import { Component, OnInit } from '@angular/core';
import {QuestionnairesModel} from "../../model/questionnaires.model";
import {ClientService} from "../../services/client.service";
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-portefolio',
  templateUrl: './portefolio.component.html',
  styleUrls: ['./portefolio.component.css']
})
export class PortefolioComponent implements OnInit {
  public startQcm: boolean;
  public profilUvalide: boolean;
  public questionnaires2:QuestionnairesModel;
  constructor(private serviceClient:ClientService, private userConnect:AuthenticationService) { }

  ngOnInit(): void {
    this.serviceClient. getQuestionnaires()
      .subscribe(data=>{
        this.questionnaires2=data;
        this.profilUvalide=this.questionnaires2.profilU;
      },error => {
        console.log(error);
      });

  }

  startQuestionnaire() {
    this.startQcm=!this.startQcm;
  }
}
