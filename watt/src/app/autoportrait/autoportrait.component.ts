import { Component, OnInit } from '@angular/core';
import {BndreamService} from "../services/bndream.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {ClientService} from "../services/client.service";
import {AuthenticationService} from "../services/authentication.service";
import {ListAutoPortraitModel} from "../model/listAutoPortrait.model";

@Component({
  selector: 'app-autoportrait',
  templateUrl: './autoportrait.component.html',
  styleUrls: ['./autoportrait.component.css']
})
export class AutoportraitComponent implements OnInit {
  public hostTest: string = "http://localhost:9004/microservice-tests";
  traitId1: number=1;
  traitId2: number=2;
  traitId3: number=3;
  traitId4: number=4;
  traitId5: number=5;
  public idTrait:Array<number>;
  public retrieveResonse1:any;
  public retrieveResonse2:any;
  public retrieveResonse3:any;
  public retrieveResonse4:any;
  public retrieveResonse5:any;
  public autoPortrait1:string;
  public autoPortrait2:string;
  public autoPortrait3:string;
  public autoPortrait4:string;
  public autoPortrait5:string;
  public iDautoPortrait1:number;
  public iDautoPortrait2:number;
  public iDautoPortrait3:number;
  public iDautoPortrait4:number;
  public iDautoPortrait5:number;
  public retrieveResonseChoix:any=null;
  constructor(private bndreamService:BndreamService, private router:Router,private httpClient: HttpClient,
              private serviceClient:ClientService, private userConnect:AuthenticationService) { }

  ngOnInit(): void {
    this.getTraitList(2);
  }

  getTraitList(number: number) {
    switch (number) {
      case 1:
        this.traitId1 =this.traitId1+5 ;
        this.traitId2=this.traitId2+5 ;
        this.traitId3=this.traitId3+5 ;
        this.traitId4=this.traitId4+5 ;
        this.traitId5=this.traitId5+5 ;
        break;
      case 0:
        this.traitId1=this.traitId1-5 ;
        this.traitId2=this.traitId2-5 ;
        this.traitId3=this.traitId3-5 ;
        this.traitId4=this.traitId4-5 ;
        this.traitId5=this.traitId5-5 ;
        break;
      default:
        this.traitId1=1;
        this.traitId2=2;
        this.traitId3=3;
        this.traitId4=4;
        this.traitId5=5;
    }
    this.idTrait=new Array<number>( this.traitId1,this.traitId2,this.traitId3,this.traitId4,this.traitId5);
    console.log(this.traitId1)
    console.log(this.traitId5)
    this.httpClient.get(this.hostTest +"/autoportraitAll/" + this.idTrait)
      .subscribe(
        res => {
          this.retrieveResonse1 = res[0];
          this.autoPortrait1=this.retrieveResonse1.personnalite;
          this.iDautoPortrait1=this.retrieveResonse1.id;
          this.retrieveResonse2 = res[1];
          this.autoPortrait2=this.retrieveResonse2.personnalite;
          this.iDautoPortrait2=this.retrieveResonse2.id;
          this.retrieveResonse3 = res[2];
          this.autoPortrait3=this.retrieveResonse3.personnalite;
          this.iDautoPortrait3=this.retrieveResonse3.id;
          this.retrieveResonse4  = res[3];
          this.autoPortrait4=this.retrieveResonse4.personnalite;
          this.iDautoPortrait4=this.retrieveResonse4.id;
          this.retrieveResonse5 = res[4];
          this.autoPortrait5=this.retrieveResonse5.personnalite;
          this.iDautoPortrait5=this.retrieveResonse5.id;
        }
      );
  }

  imageClientChoix(traitId1: number,idAutoPortrait:number) {
    this.httpClient.get(this.hostTest +"/getId/"+idAutoPortrait)
      .subscribe(
        res => {
          this.retrieveResonseChoix = res;


        })

        }
}
