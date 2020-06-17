import {Component, HostListener, OnInit} from '@angular/core';
import {ClientService} from "../services/client.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Client} from "../model/client.model";

@Component({
  selector: 'app-new-client',
  templateUrl: './new-client.component.html',
  styleUrls: ['./new-client.component.css']
})
export class NewClientComponent implements OnInit {
  public currentClient:Client;
  public mode: number=1;
  public clients:any;
  public size:number=1;
  public currentPage:number=1;
  public  totalPage:number;
  public  pages:Array<number>;
  private currentKeyword: string="";
  private  idClient:number;
  public modeClient:number=0;
  constructor(private clientService:ClientService, private router:Router,private activatedRoute:ActivatedRoute) { }
@HostListener('click')
click(){
    this.clientService.client();
}
  ngOnInit(): void {

  }
//CLIENT
  onGetClient() {
    this.clientService.getClient(this.currentPage,this.size)
      .subscribe(data=>{
        console.log(data);
        this.totalPage=data["totalPages"];
        console.log(this.totalPage);
        this.pages=new Array<number>(this.totalPage);
        this.clients=data["content"];

      },error => {
        console.log(error);
      })
  }

  onPageClient(i: number) {
    this.currentPage=i;
    this.chercherClient();
  }
  onChercher(form: any){
    this.currentPage=0;
    this.currentKeyword=form.keyword;
    this.chercherClient();
  }

  chercherClient() {
    this.clientService.getClientByKey(this.currentKeyword,this.currentPage,this.size)
      .subscribe(data=>{
        console.log(data);
        this.totalPage=data["totalPages"];

        this.pages=new Array<number>(this.totalPage);
        this.clients=data["content"];

      },error => {
        console.log(error);
      })
  }

  onDeleteClient(p) {
    let conf=confirm("Etes vous sûre?")
    if(conf){
      this.idClient=p.num;
      this.clientService.deleteClient(this.idClient)
        .subscribe(data=>{
          this.chercherClient();

        },error => {
          console.log(error)

        })
    }


  }

  onEditClient(p) {
    this.idClient =p.num;
    this.modeClient=2;
    this.clientService.getClientBy(this.idClient)
      .subscribe(data=>{
        this.currentClient=data;
      },error => {
        console.log(error);
      } )

  }


  onSaveProduit(data: any) {
    this.clientService.saveResource(this.clientService.hostUser+"/saveUser",data)
      .subscribe(res=>{
        this.currentClient=res;
        this.mode=2;
       /* this.routeur.navigateByUrl("/flooter")*/
      },error => {
        console.log(error)
      })
    console.log(data);

  }

  onNewClient() {
    this.mode=1;
  }

  onNewClientAfficher() {
    this.modeClient=1;
  }
  ofNewClientAfficher() {
    this.modeClient=0;
  }

  // Modif client

  onUpdateProduit(value: any) {
    this.clientService.updateClientBy(this.clientService.hostUser+"/modifUser/"+this.idClient,value)
      .subscribe(data=>{
        alert("Mise à jour avec succés")
        this.router.navigateByUrl("/new-client")
      },error => {
        console.log(error)
      })

  }

  modifOk() {
    this.modeClient=0;
  }
}
