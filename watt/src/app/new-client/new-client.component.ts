import {Component, HostListener, OnInit} from '@angular/core';
import {ClientService} from "../services/client.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Client} from "../model/client.model";
import {AuthenticationService} from "../services/authentication.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

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
  public message:string="";
  public messagePass:string="";
  public role:string;
  public userConnectClient:boolean;
  public userForm:FormGroup;
  hide = true;
  hide2 = true;
  public passError: boolean;

  constructor(private clientService:ClientService, private router:Router,private activatedRoute:ActivatedRoute,
              private userConnect:AuthenticationService) {
    this.userConnectClient=userConnect.userAuthenticated;
  }
@HostListener('click')
click(){
    if(this.userConnectClient){
    this.clientService.client();}
}
  ngOnInit(): void {
    this.onGetClient();

  }

  prenom=new FormControl('',Validators.required);
  password=new FormControl('',Validators.required);
  matchingPassword=new FormControl('',Validators.required);
  phone=new FormControl('',Validators.required);
  date=new FormControl('',Validators.required);
  nom=new FormControl('',Validators.required);
  email = new FormControl('', [Validators.required, Validators.email]);
 getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'Vous devez saisir une valeur';
    }
    return this.email.hasError('email') ? "Adresse mail n'est valide" : '';
  }




//CLIENT
  onGetClient() {
    this.clientService.getClient(this.currentPage,this.size)
      .subscribe(data=>{

        this.totalPage=data["totalPages"];
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
        this.totalPage=data["totalPages"];

        this.pages=new Array<number>(this.totalPage);
        this.clients=data["content"];

      },error => {
        console.log(error);
      })
  }

  /*onDeleteClient(p) {
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

  }*/


  onSaveClient(data: any) {
    this.clientService.saveResource(this.clientService.hostUser+"/saveUser",data)
      .subscribe(res=>{
        if(res==null){
          this.message="Cette adresse mail existe déjà!"
          return null;
        }
        console.log(res);
        this.currentClient=res;
        this.router.navigateByUrl("/login");
        this.mode=2;
      },error => {
        console.log(error)
      });


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

  onFormSubmit() {

    if (this.password.value!=this.matchingPassword.value){
      this.messagePass="le mot de passe n'est identique"
      this.passError=true;
      console.log(this.passError);

    }


  }
}
