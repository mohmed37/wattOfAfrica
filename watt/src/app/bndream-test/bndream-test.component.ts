import {Component, Input, OnInit} from '@angular/core';
import {AuthenticationService} from "../services/authentication.service";
import {ClientService} from "../services/client.service";
import {QuestionnairesModel} from "../model/questionnaires.model";

@Component({
  selector: 'app-bndream-test',
  templateUrl: './bndream-test.component.html',
  styleUrls: ['./bndream-test.component.css']
})

export class BndreamTestComponent implements OnInit {
  public coupe:string="assets/img/coupe.jpg";
  public depart:string="assets/img/depart.jpg";
  constructor(public authService:AuthenticationService,private clientService:ClientService) { }
  public questionnaires:QuestionnairesModel;
  public photolangage:boolean=false;



  ngOnInit(): void {
    this.clientService. getQuestionnaires()
      .subscribe(data=>{
        this.questionnaires=data;
        this.photolangage=this.questionnaires.photoLangage;

      },error => {
        console.log(error);
      })
  }
}
