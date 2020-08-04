import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthenticationService} from "./authentication.service";
import {Observable} from "rxjs";
import {QuestionnairesModel} from "../model/questionnaires.model";
import {RoueDeLaVieModel} from "../model/roueDeLaVie.model";
import {FicheMetier} from "../model/ficheMetier.model";

@Injectable({
  providedIn: 'root'
})
export class FicheMetierService {

  constructor(private htttpClient: HttpClient,private userConnect:AuthenticationService) { }

  public hostTest: string = "http://localhost:9004/microservice-tests";

  ficheMetier(id:number):Observable<FicheMetier>{
    return this.htttpClient.get<FicheMetier>(this.hostTest + "/getFicheMetier/"+id);
  }
 ficheMetierAll(){
   return this.htttpClient.get(this.hostTest + "/getPhotoFicheMetierAll");
 }
  ficheMetierByImage(id:number):Observable<FicheMetier>{
    return this.htttpClient.get<FicheMetier>(this.hostTest + "/getPhotoFicheMetier/"+id);
  }
  getFicheMetierClient():Observable<FicheMetier>{
    console.log("service")
    return this.htttpClient.get<FicheMetier>(this.hostTest + "/getFicheMetierClient/"+this.userConnect.userAuthenticated.num);
  }


}
