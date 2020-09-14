import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthenticationService} from "./authentication.service";
import {Observable} from "rxjs";
import {QuestionnairesModel} from "../model/questionnaires.model";
import {RoueDeLaVieModel} from "../model/roueDeLaVie.model";
import {FicheMetier} from "../model/ficheMetier.model";
import {ApiService} from "./api.service";

@Injectable({
  providedIn: 'root'
})
export class FicheMetierService {

  constructor(private htttpClient: HttpClient,private userConnect:AuthenticationService,private hostTestService:ApiService) {
    this.hostTest=hostTestService.TEST_MICRO_APP;
  }

  public hostTest: string;

  ficheMetier(id:number):Observable<FicheMetier>{
    return this.htttpClient.get<FicheMetier>(this.hostTest + "/getFicheMetier/"+id);
  }
 ficheMetierAll():Observable<[]>{
   return this.htttpClient.get<[]>(this.hostTest + "/getPhotoFicheMetierAll");
 }
  ficheMetierByImage(id:number):Observable<FicheMetier>{
    return this.htttpClient.get<FicheMetier>(this.hostTest + "/getPhotoFicheMetier/"+id);
  }
  getFicheMetierClient():Observable<FicheMetier[]>{
    return this.htttpClient.get<FicheMetier[]>(this.hostTest + "/getFicheMetierClient/"+this.userConnect.userAuthenticated.num);
  }

  ficheMetierByPhotoId(id:number):Observable<FicheMetier[]>{
    return this.htttpClient.get<FicheMetier[]>(this.hostTest + "/getFicheMetierByPhotoId/"+id);
  }
  ficheMetierByMetier(metier:string):Observable<FicheMetier>{
    return this.htttpClient.get<FicheMetier>(this.hostTest + "/getFicheMetierByMetier/"+metier);
  }
}
