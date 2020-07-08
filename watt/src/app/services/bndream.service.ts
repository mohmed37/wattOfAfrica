import {Injectable, Input} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../model/client.model";
import {FicheMetier} from "../model/ficheMetier.model";
import {PhotoLangageModel} from "../model/photoLangage.model";
import {AuthenticationService} from "./authentication.service";

@Injectable({
  providedIn: 'root'
})
export class BndreamService {
  @Input() private allPhotoFicheMetier:any;
  public hostTest: string = "http://localhost:9004/microservice-tests";
  base64Data: any;
  retrieveResonse1: any;

  constructor(private htttpClient: HttpClient,private userConnect:AuthenticationService) { }


public getPhoto() {
  return this.htttpClient.get(this.hostTest + "/upload");
}

  public saveFicheMetier(url,data):Observable<FicheMetier>{
    return this.htttpClient.post<FicheMetier>(url,data.valueOf());

  }

  public savePhotLangage(url,data):Observable<PhotoLangageModel>{
    return this.htttpClient.post<PhotoLangageModel>(url,data.valueOf());

  }


  getResultPhotoLangage():Observable<PhotoLangageModel>{
    return this.htttpClient.get<PhotoLangageModel>(this.hostTest + "/getPhotoLangage/"+this.userConnect.userAuthenticated.num);

  }



}
