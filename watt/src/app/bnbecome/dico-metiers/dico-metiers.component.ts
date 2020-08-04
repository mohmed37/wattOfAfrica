import { Component, OnInit } from '@angular/core';
import {BndreamService} from "../../services/bndream.service";
import {ActivatedRoute, Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {ClientService} from "../../services/client.service";
import {AuthenticationService} from "../../services/authentication.service";
import {QuestionnairesModel} from "../../model/questionnaires.model";
import {FicheMetierService} from "../../services/fiche-metier.service";
import {FicheMetier} from "../../model/ficheMetier.model";
import {any} from "codelyzer/util/function";

@Component({
  selector: 'app-dico-metiers',
  templateUrl: './dico-metiers.component.html',
  styleUrls: ['./dico-metiers.component.css']
})
export class DicoMetiersComponent implements OnInit {
  public dicoMetiers: boolean=false;
  public testDicoMetiers:boolean=false ;
  public questionnaires=new QuestionnairesModel() ;
  public questionnaires2:QuestionnairesModel;
  public userId: number | any;
  imageId: number;
  retrieveResonse: any;
  base64Data: any;
  retrievedImageFicheMetier: any;

  public ficheClient:FicheMetier;
  constructor(private bndreamService:BndreamService, private router:Router,private httpClient: HttpClient,
              private serviceClient:ClientService, private userConnect:AuthenticationService,private route: ActivatedRoute,private fichemettierService:FicheMetierService) {
    this.userId=this.userConnect.userAuthenticated.num;
  }

  ngOnInit(): void {
    this.serviceClient. getQuestionnaires()
      .subscribe(data=>{
        this.questionnaires2=data;
        this.dicoMetiers=this.questionnaires2.dicoMetiers;

      },error => {
        console.log(error);
      });

  }
  listFicheMetierClient(){
    this.fichemettierService.getFicheMetierClient().subscribe(
      data=>{
       this.ficheClient=data;

       console.log(data);
       },error => {
        console.log(error);
      });

  }

  clicTestDicoMetiers() {
    this.testDicoMetiers=true;
  }

  getImageFicheMeier(idImage:number) {
    console.log(idImage);
    this.fichemettierService.ficheMetierByImage(idImage)

      .subscribe(
        res => {
          this.retrieveResonse = res;
          this.base64Data = this.retrieveResonse.picByte;
       this.retrievedImageFicheMetier = 'data:image/jpeg;base64,' + this.base64Data;
        }
      );

  }

  onChange(event: Event) {
    console.log(event)

  }
}
