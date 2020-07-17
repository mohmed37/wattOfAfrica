import {Component, Input, OnInit} from '@angular/core';
import {AuthenticationService} from "../services/authentication.service";
import {ClientService} from "../services/client.service";
import {QuestionnairesModel} from "../model/questionnaires.model";
import {BndreamService} from "../services/bndream.service";

@Component({
  selector: 'app-bndream-test',
  templateUrl: './bndream-test.component.html',
  styleUrls: ['./bndream-test.component.css']
})

export class BndreamTestComponent implements OnInit {
  public coupe:string="assets/img/coupe.jpg";
  public depart:string="assets/img/depart.jpg";
  constructor(public authService:AuthenticationService,private clientService:ClientService,private bndreamService:BndreamService  ) { }
  public questionnaires:QuestionnairesModel;
  public photolangage:boolean=false;
  private roueVie: boolean=false;

  public progression:number=0;


  ngOnInit(): void {
    this.clientService. getQuestionnaires()
      .subscribe(data=>{
        this.questionnaires=data;
        this.photolangage=this.questionnaires.photoLangage;
        this.roueVie=this.questionnaires.roueVie;

        if (this.photolangage){
          this.progression=20;
        }
        if (this.roueVie){
          this.progression=40;
        }

      },error => {
        console.log(error);
      });


  }


}
