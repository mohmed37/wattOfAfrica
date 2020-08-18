import { Component, OnInit } from '@angular/core';
import {BndreamService} from "../../services/bndream.service";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {ClientService} from "../../services/client.service";
import {AuthenticationService} from "../../services/authentication.service";
import {FicheMetierService} from "../../services/fiche-metier.service";
import {Bnbecome} from "../../services/bnbecome.service";
import {QuestionnairesModel} from "../../model/questionnaires.model";
import {ProfilUModel} from "../../model/profilU.model";
import {MatRadioButton, MatRadioChange} from "@angular/material/radio";
import {ResulttatProfilUModel} from "../../model/resulttatProfilU.model";
import {ResultatRaModel} from "../../model/resultatRa.model";

@Component({
  selector: 'app-profil-u',
  templateUrl: './profil-u.component.html',
  styleUrls: ['./profil-u.component.css']
})
export class ProfilUComponent implements OnInit {
  public userId: number | any;
  public questionnaires2:QuestionnairesModel;
  public dicoMetiersValide: boolean;
  public listQuestionProfilU:ProfilUModel[];
  public question:string;
  public numeroQcm:number=0;
  public validebutton: boolean;
  public resultatProfilU:ResulttatProfilUModel[]=[];
  public resultatProfilUNew=[];
  public profilUnew:ResulttatProfilUModel=new ResulttatProfilUModel('','','',0);
  public nombre:number=0;
  public resultRa:ResultatRaModel=new ResultatRaModel(this.userId,0,0,0,0,
    0,0,0,0,0,0,0,0,
    0,0);
  public getResulta:ResultatRaModel;
  public resulta: boolean;
  public profilUvalide: boolean;





  constructor(private bndreamService:BndreamService, private router:Router,private httpClient: HttpClient,
              private serviceClient:ClientService, private userConnect:AuthenticationService,private route: ActivatedRoute
    ,private fichemettierService:FicheMetierService,private bnbecome:Bnbecome) {
    this.userId=this.userConnect.userAuthenticated.num;
  }

  ngOnInit(): void {
    this.serviceClient. getQuestionnaires()
      .subscribe(data=>{
        this.questionnaires2=data;
        this.dicoMetiersValide=this.questionnaires2.dicoMetiers;
        this.profilUvalide=this.questionnaires2.profilU;
      },error => {
        console.log(error);
      });
    this.getQuestionnaireProfilU();
  }

  getQuestionnaireProfilU(){
    this.bnbecome.getQuestionnaireProfileU().subscribe(data=>{
      this.listQuestionProfilU=data;
      this.question=this.listQuestionProfilU[this.numeroQcm].question;
      this.getProfilU(this.listQuestionProfilU)
    });


  }

  getProfilU(listQuestionProfilU: ProfilUModel[]){

  for (let i = 0; i <listQuestionProfilU.length; i++) {
    this.profilUnew.dimention=listQuestionProfilU[i].dimention;
    this.profilUnew.item=listQuestionProfilU[i].item;
    this.profilUnew.code=listQuestionProfilU[i].code;
    this.profilUnew.point=0;
    for (let i = 0; i <this.resultatProfilU.length; i++) {
      if(this.resultatProfilU[i].dimention==this.profilUnew.dimention){
        return null;
      }
    }
    this.resultatProfilU[i]={dimention:this.profilUnew.dimention,item:this.profilUnew.item,
      code:this.profilUnew.code,point:this.profilUnew.point};
  }

}




  clic(event: MatRadioChange) {
    let value:number;
    if(event.value==1||event.value==10){value=1}
    if(event.value==2||event.value==20){value=2}
    if(event.value==3||event.value==30){value=3}
    if(event.value==4||event.value==40){value=4}
    if(event.value==5||event.value==50){value=5}

    for (let i = 0; i < this.resultatProfilU.length; i++) {
      if(this.resultatProfilU[i].dimention == this.listQuestionProfilU[this.numeroQcm].dimention){
        this.resultatProfilU[i].point=this.resultatProfilU[i].point+value;
        if (this.numeroQcm==this.listQuestionProfilU.length-1){
          return this.calculProfilU(this.resultatProfilU);
        }
      }
    }
    this.numeroQcm=this.numeroQcm+1;
    this.question=this.listQuestionProfilU[this.numeroQcm].question;
    this.validebutton=!this.validebutton;

  }

  calculProfilU(resultatProfilU: ResulttatProfilUModel[]){

    for (let i = 0; i < resultatProfilU.length; i++){
      switch (resultatProfilU[i].dimention) {
        case "authenticite":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.authenticite=this.resultRa.authenticite+(5-Ra1);
          break;
        }
        case "strategie":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.authenticite=this.resultRa.authenticite+(Rb/5);
          break;
        }
        case "tenacite":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.tenacite=this.resultRa.tenacite+(5-Ra1);
          break;
        }
        case "flexibilite":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.tenacite=this.resultRa.tenacite+(Rb/5);
          break;
        }
        case "reactivite":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.reactivite=this.resultRa.reactivite+(5-Ra1);
          break;
        }
        case "stabilite":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.reactivite=this.resultRa.reactivite+(Rb/5);
          break;
        }
        case "introversion":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.introversion=this.resultRa.introversion+(5-Ra1);
          break;
        }
        case "extraversion":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.introversion=this.resultRa.introversion+(Rb/5);
          break;
        }
        case "methode":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.methode=this.resultRa.methode+(5-Ra1);
          break;
        }
        case "improvisation":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.methode=this.resultRa.methode+(Rb/5);
          break;
        }
        case "intuition":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.intuition=this.resultRa.intuition+(5-Ra1);
          break;
        }
        case "rationalisme":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.intuition=this.resultRa.intuition+(Rb/5);
          break;
        }
        case "nonConformisme":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.nonConformisme=this.resultRa.nonConformisme+(5-Ra1);
          break;
        }
        case "droiture":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.nonConformisme=this.resultRa.nonConformisme+(Rb/5);
          break;
        }
        case "personnelle":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.personnelle=this.resultRa.personnelle+(5-Ra1);
          break;
        }
        case "professionnelle":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.personnelle=this.resultRa.personnelle+(Rb/5);
          break;
        }
        case "directive":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.directive=this.resultRa.directive+(5-Ra1);
          break;
        }
        case "pouvoir":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.directive=this.resultRa.directive+(Rb/5);
          break;
        }

        case "prudence":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.prudence=this.resultRa.prudence+(5-Ra1);
          break;
        }
        case "competition":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.prudence=this.resultRa.prudence+(Rb/5);
          break;
        }

        case "gregarite":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.gregarite=this.resultRa.gregarite+(5-Ra1);
          break;
        }
        case "autonomie":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.gregarite=this.resultRa.gregarite+(Rb/5);
          break;
        }
        case "individualisme":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.individualisme=this.resultRa.individualisme+(5-Ra1);
          break;
        }
        case "altruisme":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.individualisme=this.resultRa.individualisme+(Rb/5);
          break;
        }
        case "traditionnel":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.traditionnel=this.resultRa.traditionnel+(5-Ra1);
          break;
        }
        case "exploration":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.traditionnel=this.resultRa.traditionnel+(Rb/5);
          break;
        }
        case "reflexion":{
          const Ra:number=resultatProfilU[i].point;
          const Ra1:number=Ra/5;
          this.resultRa.reflexion=this.resultRa.reflexion+(5-Ra1);
          break;
        }
        case "action":{
          const Rb:number=resultatProfilU[i].point;
          this.resultRa.reflexion=this.resultRa.reflexion+(Rb/5);
          break;
        }

      }

      }
    this.saveProfilU()

      }
      saveProfilU(){
    this.resultRa.idclient=this.userId;
    this.bnbecome.saveProfilU(this.resultRa).subscribe(data=>{
      this.serviceClient.putQuestionnaires("profilU");
      this.getResultatProfilU();
      },error => {
  console.log(error);
});
      }

  getResultatProfilU(){
    this.bnbecome.getResultatProfileU().subscribe(data=>{
      this.getResulta=data;
      this.resulta=true;
      console.log(this.getResulta);
    });
  }
  closeResultatProfiliU(){
    this.resulta=false;
  }


}
