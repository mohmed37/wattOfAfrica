import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {tap} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private htttpClient: HttpClient) { }
  private users=[
    {usemane:'admin',password:'1234',roles:['ADMIN','USER']},
    {usemane:'user1',password:'1234',roles:['USER']},
    {usemane:'user2',password:'1234',roles:['USER']},
  ];
  public isAuthenticated:boolean;
  public userAuthenticated;
  public token:string;
  public hostUser: string = "http://localhost:9004/microservice-utilisateur";

  public signin(credential: { email: string; password: string }):Observable<string>{

    return this.htttpClient.post<string>(this.hostUser+"/authUser",credential).pipe(

      tap((client: string)=>{
        console.log(client);
      })

    ) };




  isUserLoggedIn(username:string,password:string) {
    let user;
    this.users.forEach(u=>{
      if(u.usemane==username&&u.password==password){
        user=u;
        this.token= btoa(JSON.stringify({
          username:u.usemane,
          roles:u.roles
        }));
      }
    });
    if (user){
      this.isAuthenticated=true;
      this.userAuthenticated=user;

    }else {
      this.isAuthenticated=false;
      this.userAuthenticated=undefined;
    }
  }

  public isAdmin(){
    if (this.userAuthenticated){
      if (this.userAuthenticated.roles.indexOf('ADMIN')>-1)
        return true;
    }
    return false;

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
      username:user.username,roles:user.roles};
    this.isAuthenticated=true;
    this.token=tokenNew;
    }
  }

  public removeTokenFromLocalStorage(){
    localStorage.removeItem('userToken');
    this.isAuthenticated=false;
    this.token=undefined;
    this.userAuthenticated=undefined;

  }
}
