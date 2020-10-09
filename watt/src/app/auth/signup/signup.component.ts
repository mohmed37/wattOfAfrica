import {Component, HostListener, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ClientService} from "../../services/client.service";
import {Client} from "../../model/client.model";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public currentClient:Client;
  public mode: number=1;
  public clients:any;
  public size:number=1;
  public currentPage:number=1;
  public  totalPage:number;
  public  pages:Array<number>;
  public message:string="";
  public messagePass:string="";
  public role:string;
  public userConnectClient:boolean;
  public userForm:FormGroup;
  hide = true;
  hide2 = true;
  public passError: string='';
  public newClient:Client=new Client();
  public fragment: string;

  constructor(private clientService:ClientService, private router:Router,private activatedRoute:ActivatedRoute,
              private userConnect:AuthenticationService,private route: ActivatedRoute) {
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

  ngAfterViewInit() {
    this.route.fragment.subscribe(fragment => {
      this.fragment = fragment;
      setTimeout(() => this.scrollToAnchor(), 10);
    });
  }

  scrollToAnchor(): void {
    try {
      if (this.fragment) {
        document.querySelector('#' + this.fragment).scrollIntoView();
      }
    } catch (e) { }
  }

  prenom=new FormControl('',Validators.required);
  password=new FormControl('',Validators.required);
  usernam=new FormControl('',Validators.required);
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



  onFormSubmit() {
    this.passError="";
    this.message="";
    if (this.password.value!=this.matchingPassword.value){
      this.passError="Les mots de passe saisis ne sont pas identiques.";
      return null;
    }

    this.newClient.prenom=this.prenom.value;
    this.newClient.nom=this.nom.value;
    this.newClient.email=this.email.value;
    this.newClient.phone=this.phone.value;
    this.newClient.password=this.password.value;
    this.newClient.username=this.usernam.value;
    this.newClient.role=[""];
  /*  this.newClient.matchingPassword=this.matchingPassword.value;
    this.newClient.date=this.date.value;*/
    this.clientService.saveResource(this.clientService.hostUser+"/signup",this.newClient)
      .subscribe(res=>{
        this.currentClient=res;
        this.router.navigateByUrl("/login");
        this.mode=2;
      },error => {
console.log(error);
        this.message=error.error.message;
      });
  }
}
