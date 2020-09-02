import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {tap} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {Client} from "../model/client.model";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {


  constructor(private htttpClient: HttpClient) { }

  public isAuthenticated:boolean;
  public userAuthenticated;
  public token:string;
  public hostUser: string = "http://localhost:9004/microservice-utilisateur";
  public currentClient=new Client();
  public isUserAdmin:boolean=false;
  public isUserUser: boolean=false;

  public clientConnect(user){

    return  this.htttpClient.post<Client>(this.hostUser +"/authUser",user).subscribe(userConnect=>{

      this.token= btoa(JSON.stringify({
        username:userConnect.email,
        roles:userConnect.roles[0].role,
        num:userConnect.num,
        nom:userConnect.nom,
        prenom:userConnect.prenom
      }));


      if (userConnect){
        this.isAuthenticated=true;
        this.userAuthenticated=userConnect;
        this.currentClient=userConnect;
        if (this.userAuthenticated.roles[0].role.indexOf('ROLE_ADMIN')>-1){
          return this.isUserAdmin=true;
        }
        if (this.userAuthenticated.roles[0].role.indexOf('ROLE_USER')>-1){
          return this.isUserUser=true;
        }
      }else {
        this.isAuthenticated=false;
        this.userAuthenticated=undefined;
      }
    });

  }




  public saveAuthenticateurUser() {
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
  }

  public removeTokenFromLocalStorage(){
    localStorage.removeItem('userToken');
    this.isAuthenticated=false;
    this.token=undefined;
    this.userAuthenticated=undefined;
    this.isUserAdmin=false;
    this.isUserUser=false;
  }
}
