import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {config} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private BASE_URL =environment.backendServer;
  public TEST_MICRO_APP =`${this.BASE_URL}/microservice-tests`;
  public USERS_MICRO_APP =`${this.BASE_URL}/microservice-utilisateur`;


  constructor(private http:HttpClient) { }
}
