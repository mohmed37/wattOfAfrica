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
  public serviceClient;
  public serviceBream;
  constructor(public authService:AuthenticationService,private clientService:ClientService,private bndreamService:BndreamService  ) {
    this.serviceClient=clientService;
    this.serviceBream=this.bndreamService;
  }
  public questionnaires:QuestionnairesModel;
  public photolangage:boolean=false;
  public roueVie: boolean=false;
  public autoportrait: boolean=false;
  public qcm1:boolean=false;
  public qcm2:boolean=false;
  public qcm3:boolean=false;
  public qcm4:boolean=false;
  public progression:number=0;


  ngOnInit(): void {
    this.serviceClient. getQuestionnaires()
      .subscribe(data=>{
        this.questionnaires=data;
        this.photolangage=this.questionnaires.photoLangage;
        this.roueVie=this.questionnaires.roueVie;
        this.autoportrait=this.questionnaires.autoPortrait;
        this.qcm1=this.questionnaires.qcm1;
        this.qcm2=this.questionnaires.qcm2;
        this.qcm3=this.questionnaires.qcm3;
        this.qcm4=this.questionnaires.qcm4;


        if (this.photolangage){
          this.progression=20;
        }
        if (this.roueVie){
          this.progression=40;
        }
        if (this.autoportrait){
          this.progression=60;
        }
        if (this.qcm1){
          this.progression=65;
        }
        if (this.qcm2){
          this.progression=75;
        }
        if (this.qcm3){
          this.progression=85;
        }
        if (this.qcm4){
          this.progression=90;
        }

      },error => {
        console.log(error);
      });


  }


}
