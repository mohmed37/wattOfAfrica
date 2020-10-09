import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {tap} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {Client} from "../model/client.model";
import {FicheMetierService} from "./fiche-metier.service";
import {ApiService} from "./api.service";
import {ClientService} from "./client.service";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {


  constructor(private htttpClient: HttpClient,private hostTestService:ApiService, private router: Router ) {
    this.hostUser=hostTestService.USERS_MICRO_APP;

  }

  public isAuthenticated:boolean;
  public userAuthenticated;
  public token:string;
  public hostUser: string;
  public currentClient=new Client();
  public isUserAdmin:boolean=false;
  public isUserUser: boolean=false;

  public clientConnect(userConnect){
    sessionStorage.setItem('username',userConnect.username);
    let tokenStr= 'Bearer '+userConnect.accessToken;
    sessionStorage.setItem('token', tokenStr);
    sessionStorage.setItem('id',userConnect.id);

      if (userConnect){

        this.isAuthenticated=true;
        this.userAuthenticated=userConnect;
        this.currentClient=userConnect;
        if (this.userAuthenticated.roles[0] == 'ROLE_ADMIN'){
          return this.isUserAdmin=true;
        }
        if (this.userAuthenticated.roles[0]=='ROLE_ELEVE'){
          return this.isUserUser=true;
        }
      }else {
        this.isAuthenticated=false;
        this.userAuthenticated=undefined;
      }

  /*  this.saveAuthenticateurUser();*/
  }




 /* public saveAuthenticateurUser() {
   if(this.userAuthenticated){
     localStorage.setItem('userToken',this.token);
   }
  }
  public loadAuthenticatedUserFromLocalSorage(){
    let tokenNew=localStorage.getItem('userToken');
    if(tokenNew){
    let user=JSON.parse(atob(tokenNew));
    this.userAuthenticated={
      username:user.username,
      roles:user.roles,
      num:user.num,
      prenom:user.prenom,
      nom:user.nom,
    };
    this.isAuthenticated=true;
    this.token=tokenNew;
    }
  }*/

  public removeTokenFromLocalStorage(){
    sessionStorage.removeItem('username')
   /* localStorage.removeItem('userToken');*/
    this.isAuthenticated=false;
    this.token=undefined;
    this.userAuthenticated=undefined;
    this.isUserAdmin=false;
    this.isUserUser=false;
  }
}
