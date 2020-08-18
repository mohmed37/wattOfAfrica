import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthenticationService} from "./authentication.service";
import {Observable} from "rxjs";
import {ListMetierClientModel} from "../model/listMetierClient.model";
import {ProfilUModel} from "../model/profilU.model";
import {ResultatRaModel} from "../model/resultatRa.model";

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
}
