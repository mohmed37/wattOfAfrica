import {Injectable, Input} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../model/client.model";
import {FicheMetier} from "../model/ficheMetier.model";
import {PhotoLangageModel} from "../model/photoLangage.model";
import {AuthenticationService} from "./authentication.service";
import {RoueDeLaVieModel} from "../model/roueDeLaVie.model";
import {ChoixAutoPortraitModel} from "../model/choixAutoPortrait.model";
import {Questionnaire1Model} from "../model/questionnaire1.model";
import {ResultatPraicoModel} from "../model/resultatPraico.model";
import {Questionnaire2Model} from "../model/questionnaire2.model";
import {Questionnaire4Model} from "../model/questionnaire4.model";
import {ListHeroModel} from "../model/listHero.model";
import {ResultatHeroModel} from "../model/resultatHero.model";
import {FicheMetierService} from "./fiche-metier.service";
import {ApiService} from "./api.service";

@Injectable({
  providedIn: 'root'
})
export class BndreamService {
  @Input() private allPhotoFicheMetier:any;
  public hostTest: string;
  base64Data: any;
  retrieveResonse1: any;
  public resultroueDeLaVie: RoueDeLaVieModel;

  constructor(private htttpClient: HttpClient,private userConnect:AuthenticationService,private hostTestService:ApiService ) {
    this.hostTest=hostTestService.TEST_MICRO_APP;
  }


public getPhoto() {
  return this.htttpClient.get(this.hostTest + "/upload");
}

  public saveFicheMetier(url,data):Observable<FicheMetier>{
    return this.htttpClient.post<FicheMetier>(url,data.valueOf());

  }

  public savePhotLangage(url,data):Observable<PhotoLangageModel>{
    return this.htttpClient.post<PhotoLangageModel>(url,data.valueOf());

  }
  public saveRoueDeLaVie(url,data):Observable<RoueDeLaVieModel>{
    return this.htttpClient.post<RoueDeLaVieModel>(url,data.valueOf());

  }
  public saveAutoPortrait(url,data):Observable<ChoixAutoPortraitModel> {
    return this.htttpClient.post<ChoixAutoPortraitModel>(url,data.valueOf());
  }

  public savepraico(url,data):Observable<ResultatPraicoModel> {
    return this.htttpClient.post<ResultatPraicoModel>(url,data.valueOf());
  }

  public saveQcm4(url,data):Observable<Questionnaire4Model> {
    return this.htttpClient.post<Questionnaire4Model>(url,data.valueOf());
  }

  public saveHero(url,data):Observable<ResultatHeroModel> {
    return this.htttpClient.post<ResultatHeroModel>(url,data.valueOf());
  }

  getResultPhotoLangage():Observable<PhotoLangageModel>{
    return this.htttpClient.get<PhotoLangageModel>(this.hostTest + "/getPhotoLangage/"+this.userConnect.userAuthenticated.num);

  }
  getResultRoueDeLaVie():Observable<RoueDeLaVieModel>{
    return this.htttpClient.get<RoueDeLaVieModel>(this.hostTest + "/getRoueVieClient/"+this.userConnect.userAuthenticated.num);

  }

  getResultAutoPortrait():Observable<ChoixAutoPortraitModel>{
    return this.htttpClient.get<ChoixAutoPortraitModel>(this.hostTest + "/getResulAutoportrait/"+this.userConnect.userAuthenticated.num);

  }

  getQustionnaire1(id:number):Observable<Questionnaire1Model>{
    return this.htttpClient.get<Questionnaire1Model>(this.hostTest + "/questionnaire1/"+id);
  }
  getQustionnaire2(id:number):Observable<Questionnaire2Model>{
    return this.htttpClient.get<Questionnaire2Model>(this.hostTest + "/questionnaire2/"+id);
  }

  getQustionnaire3(id:number):Observable<Questionnaire2Model>{
    return this.htttpClient.get<Questionnaire2Model>(this.hostTest + "/questionnaire3/"+id);
  }

  getQustionnaire4():Observable<Questionnaire4Model[]> {
    return this.htttpClient.get<Questionnaire4Model[]>(this.hostTest + "/questionnaire4/");
  }

  getResultPraico():Observable<ResultatPraicoModel> {
    return this.htttpClient.get<ResultatPraicoModel>(this.hostTest + "/praicoIdClient/"+this.userConnect.userAuthenticated.num);
  }
  getResultHero():Observable<ResultatHeroModel> {
    return this.htttpClient.get<ResultatHeroModel>(this.hostTest + "/getResultHeroClient/"+this.userConnect.userAuthenticated.num);
  }

  getListHero():Observable<ListHeroModel[]> {
    return this.htttpClient.get<ListHeroModel[]>(this.hostTest + "/listvaleurHero");
  }
}
