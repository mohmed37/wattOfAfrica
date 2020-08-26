import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthenticationService} from "./authentication.service";
import {Observable} from "rxjs";
import {ListMetierClientModel} from "../model/listMetierClient.model";
import {ProfilUModel} from "../model/profilU.model";
import {ResultatRaModel} from "../model/resultatRa.model";
import {RestitutionProfilUModel} from "../model/restitutionProfilU.model";
import {ListCompetencesModel} from "../model/listCompetences.model";
import {ListCompetencesClientModel} from "../model/listCompetencesClient.model";

@Injectable({
  providedIn: 'root'
})
export class Bnbecome{
  public hostTest: string = "http://localhost:9004/microservice-tests";
  constructor(private htttpClient: HttpClient,private userConnect:AuthenticationService) {

  }
  public saveListMetierClient(url,data):Observable<ListMetierClientModel>{
    return this.htttpClient.post<ListMetierClientModel>(url,data.valueOf());
  }
  public modifListMetierClient(url,data):Observable<ListMetierClientModel>{
    return this.htttpClient.put<ListMetierClientModel>(url,data.valueOf());
  }
  getFicheMetierClient():Observable<ListMetierClientModel>{
    return this.htttpClient.get<ListMetierClientModel>(this.hostTest + "/getMetierByClient/"+this.userConnect.userAuthenticated.num);
  }

  getQuestionnaireProfileU():Observable<ProfilUModel[]>{
    return this.htttpClient.get<ProfilUModel[]>(this.hostTest + "/listQuestion/");
  }
  public saveProfilU(data):Observable<ResultatRaModel>{
    return this.htttpClient.post<ResultatRaModel>(this.hostTest + "/saveClientRa/",data.valueOf());
  }
  getResultatProfileU():Observable<ResultatRaModel>{
    return this.htttpClient.get<ResultatRaModel>(this.hostTest + "/questionClient/"+this.userConnect.userAuthenticated.num);
  }

  getRestitusionProfilU():Observable<RestitutionProfilUModel[]>{
    return this.htttpClient.get<RestitutionProfilUModel[]>(this.hostTest + "/restitusionAll/");
  }

  getRestitusionProfilUByPosAndDim(dimension:string,position:number):Observable<RestitutionProfilUModel>{
    return this.htttpClient.get<RestitutionProfilUModel>(this.hostTest + "/restitusionByDimAndPos/"+dimension+"/"+position);

  }

  public saveCompetence(data):Observable<ListCompetencesModel>{
    return this.htttpClient.post<ListCompetencesModel>(this.hostTest + "/saveListCompetences/",data.valueOf());
  }

  getCompetence():Observable<ListCompetencesModel[]>{
    return this.htttpClient.get<ListCompetencesModel[]>(this.hostTest + "/listCompetences/");
  }

  getCompetenceById(id:number):Observable<ListCompetencesModel>{
    return this.htttpClient.get<ListCompetencesModel>(this.hostTest + "/getCompetenceById/"+id);

  }
  getCompetenceByCompetence(competence:string):Observable<ListCompetencesModel>{

    return this.htttpClient.get<ListCompetencesModel>(this.hostTest + "/getCompetenceByCompetence/"+competence);
  }

  public saveCompetenceClient(data):Observable<ListCompetencesClientModel>{
    console.log(data.valueOf());
    return this.htttpClient.post<ListCompetencesClientModel>(this.hostTest + "/saveListCompetencesClient/",data.valueOf());
  }

  getCompetenceClient():Observable<ListCompetencesClientModel>{

    return this.htttpClient.get<ListCompetencesClientModel>(this.hostTest + "/getCompetenceClientByIdClient/"+this.userConnect.userAuthenticated.num);
  }


}
