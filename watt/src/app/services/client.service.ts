import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../model/client.model";

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  public hostUser: string = "http://localhost:9004/microservice-utilisateur";
  public  modeClient:number=0;

  constructor(private htttpClient: HttpClient) {
  }

  public getClient(page: number, size: number) {
    return this.htttpClient.get(this.hostUser + "/usersAll?page=" + page + "&size=" + size);
  }

  public getClientByKey(prenon:string,page: number, size: number) {
    return this.htttpClient.get(this.hostUser + "/usersAll?prenom="+prenon+"&page="+page+"&size="+size);

  }
  public deleteClient(id:number) {
    return this.htttpClient.delete(this.hostUser +"/deleteUser/"+id);

  }
  public saveResource(url,data):Observable<Client>{
    return this.htttpClient.post<Client>(url,data);
  }

  public getClientBy(id):Observable<Client> {
    return this.htttpClient.get<Client>(this.hostUser +"/user/"+id);

  }

  public updateClientBy(url,data) {
    return this.htttpClient.put(url,data);

  }
}
