import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";
import {ClientService} from "../../services/client.service";
import {BndreamService} from "../../services/bndream.service";
import {ActivatedRoute, Router} from "@angular/router";
import {QuestionnairesModel} from "../../model/questionnaires.model";

@Component({
  selector: 'app-accueil-bnbcome',
  templateUrl: './accueil-bnbcome.component.html',
  styleUrls: ['./accueil-bnbcome.component.css']
})
export class AccueilBnbcomeComponent implements OnInit {
 public dicoMetiers:boolean=false;
  public porteFolio:boolean=false;
  public profilU:boolean=false;
  public projetPro:boolean=false;
  public serviceBream;
  public serviceClient;
  public questionnaires:QuestionnairesModel;
  public testsActif: boolean=false;
  public coupe:string="assets/img/coupe.jpg";
  public depart:string="assets/img/depart.jpg";
  public progression:number=0;
  public fragment: string;
  public ListQuestionnaire:any[];
  public clientConnect:boolean;
  public contexteImg:string="assets/img/contexte.jpg";
  public objectifImg:string="assets/img/objectuf.jpg";
  public processImg:string="assets/img/consigne.jpg";
  public contexteValide:boolean=false;
  public objectifValide: boolean=false;
  public processValide: boolean=false;

  constructor(public authService:AuthenticationService,private clientService:ClientService
    ,private router:Router,private route: ActivatedRoute, private userConnect:AuthenticationService) {
    this.serviceClient=clientService;
    this.clientConnect=this.authService.userAuthenticated;

  }

  ngOnInit(): void {
    if(this.authService.userAuthenticated){
      this.clientService.getQuestionnairesAll().subscribe(list=>{
        this.ListQuestionnaire=list;
        this.ListQuestionnaire.forEach(questionnaireUser=>{
          if (questionnaireUser.user.num==this.userConnect.userAuthenticated.num){
            this.serviceClient. getQuestionnaires()
              .subscribe(data=>{
                this.questionnaires=data;
                this.dicoMetiers=this.questionnaires.dicoMetiers;
                this.porteFolio=this.questionnaires.porteFolio;
                this.profilU=this.questionnaires.profilU;
                this.projetPro=this.questionnaires.projetPro;

                if (this.dicoMetiers){
                  this.progression=20;
                }
                if (this.porteFolio){
                  this.progression=40;
                }
                if (this.profilU){
                  this.progression=80;
                }
                if (this.projetPro){
                  this.progression=100;
                }

              },error => {
                console.log(error);
              });

          }else {
            return null;
          }

        })
      });
    }
  }

  ngAfterViewInit() {
    this.route.fragment.subscribe(fragment => {
      this.fragment = fragment;
      setTimeout(() => this.scrollToAnchor(), 10);
    });
  }

  scrollToAnchor(): void {
    try {
      if (this.fragment) {
        document.querySelector('#' + this.fragment).scrollIntoView();
      }
    } catch (e) { }
  }

  contexte() {
    if(!this.contexteValide){
      this.contexteValide=true;
      this.objectifValide=false;
      this.processValide=false;
      this.router.navigate(['/bnBeleave'], { fragment: 'contexte' });
    }else {
      this.contexteValide=false;
      this.router.navigate(['/bnBeleave'], { fragment: 'haut' });
    }
  }

  objectif() {
    if(!this.objectifValide){
      this.objectifValide=true;
      this.contexteValide=false;
      this.processValide=false;
      this.router.navigate(['/bnBeleave'], { fragment: 'objectif' });
    }else {
      this.objectifValide=false;
      this.router.navigate(['/bnBeleave'], { fragment: 'haut' });

    }
  }
  process() {
    if(!this.processValide){
      this.processValide=true;
      this.objectifValide=false;
      this.contexteValide=false;
      this.router.navigate(['/bnBeleave'], { fragment: 'process' });
    }else {
      this.processValide=false;
      this.router.navigate(['/bnBeleave'], { fragment: 'haut' });
    }
  }

}
