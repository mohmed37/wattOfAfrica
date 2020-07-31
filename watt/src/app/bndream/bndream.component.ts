import {Component, Input, OnInit} from '@angular/core';
import {AuthenticationService} from "../services/authentication.service";
import {ClientService} from "../services/client.service";
import {QuestionnairesModel} from "../model/questionnaires.model";
import {Observable} from "rxjs";
import {PhotoLangageModel} from "../model/photoLangage.model";
import {HttpClient} from "@angular/common/http";
import {BndreamService} from "../services/bndream.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-bndream',
  templateUrl: './bndream.component.html',
  styleUrls: ['./bndream.component.css']
})
export class BndreamComponent implements OnInit {
  public testsActif: boolean=false;
  public coupe:string="assets/img/coupe.jpg";
  public depart:string="assets/img/depart.jpg";
  public serviceBream;
  public serviceClient;
  public questionnaires:QuestionnairesModel;
  public photolangage:boolean=false;
  public roueVie: boolean=false;
  public autoportrait: boolean=false;
  public qcm1:boolean=false;
  public qcm2:boolean=false;
  public qcm3:boolean=false;
  public qcm4:boolean=false;
  public hero: boolean=false;
  public progression:number=0;
  public fragment: string;

  constructor(public authService:AuthenticationService,private clientService:ClientService
              ,private bndreamService:BndreamService,private router:Router,private route: ActivatedRoute) {
    this.serviceClient=clientService;
    this.serviceBream=this.bndreamService;
  }

  ngOnInit(): void {
    this.fragment="haut";
      if(this.authService.userAuthenticated){
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
        this.hero=this.questionnaires.hero;

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
        if (this.hero){
          this.progression=100;
        }
      },error => {
        console.log(error);
      });}
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



  tests() {
    this.testsActif=true;
  }
}
