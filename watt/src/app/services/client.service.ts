import {EventEmitter, Injectable, Output} from '@angular/core';
import {HttpClient, HttpEvent} from "@angular/common/http";
import {BehaviorSubject, Observable, Subscription} from "rxjs";
import {Client} from "../model/client.model";
import {tap} from "rxjs/operators";
import {JwtTokenModel} from "../model/jwt-token.model";
import {AuthenticationService} from "./authentication.service";
import {QuestionnairesModel} from "../model/questionnaires.model";

@Injectable({
  providedIn: 'root'
})
export class ClientService {
public jwtToken: BehaviorSubject<JwtTokenModel> = new BehaviorSubject({
  isAuthenticated: null,
  token:null
});
  public currentClient:Client;
  @Output() change: EventEmitter<Client> = new EventEmitter();
  nom:Client;


  public hostUser: string = "http://localhost:9004/microservice-utilisateur";
  public  modeClient:number=0;

  constructor(private htttpClient: HttpClient, private userConnect:AuthenticationService) {
    this.initToken();
  }

  private initToken():void {
    const token = localStorage.getItem('jwt');
   if (token){
     this.jwtToken.next({
       isAuthenticated:true,
       token:token
     });
   }else {
     this.jwtToken.next({
       isAuthenticated:false,
       token:null
     });
   }
   console.log(this.jwtToken.value)
  }

  public getClient(page: number, size: number) {
    return this.htttpClient.get(this.hostUser + "/usersAll?page=" + page + "&size=" + size);
  }


  public getClientBy(id):Observable<Client> {
    return this.htttpClient.get<Client>(this.hostUser +"/user/"+id);
  }

  public getClientByKey(prenon:string,page: number, size: number) {
    return this.htttpClient.get(this.hostUser + "/usersAll?prenom="+prenon+"&page="+page+"&size="+size);

  }
  public deleteClient(id:number) {
    return this.htttpClient.delete(this.hostUser +"/deleteUser/"+id);

  }
   public getClientConnect(){
    return this.htttpClient.get("http://localhost:8080/getConnect");
  }

  public saveResource(url,data):Observable<Client>{
    return this.htttpClient.post<Client>(url,data);
  }

  client(){
    this.htttpClient.get<Client>(this.hostUser +"/user/"+this.userConnect.userAuthenticated.num).subscribe(
      client1=>{
        this.nom=client1;
      }
    );
    this.change.emit(this.nom);
  }



  public updateClientBy(url,data) {
    return this.htttpClient.put(url,data);
  }


  public signup(user):Observable<Client>{
    console.log(user);
    return  this.htttpClient.post<Client>(this.hostUser+"/saveUser",user)
  }

  public signin(credential: {email: string, password: string}):Observable<string>{

    return this.htttpClient.post<string>(this.hostUser+"/authUser",credential).pipe(

      tap((token: string)=>{
        this.jwtToken.next({
          isAuthenticated:true,
          token:token

        });
        localStorage.setItem('jwt',token);
        console.log(token)
        })
    );
  }

  public getQuestionnaires():Observable<QuestionnairesModel>  {
    return this.htttpClient.get<QuestionnairesModel>(this.hostUser + "/questionnairesUser/"+this.userConnect.userAuthenticated.num);
  }

  public putQuestionnaires(typeQuetionnaire:string){
    return this.htttpClient.put(this.hostUser + "/modifQuestionnaire/"+this.userConnect.userAuthenticated.num,typeQuetionnaire).subscribe(data=>{

    },error => {
      console.log(error)
    });

  }

}
