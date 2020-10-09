import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ClientService} from "../../services/client.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthenticationService} from "../../services/authentication.service";
import {Client} from "../../model/client.model";
import {HttpClient} from "@angular/common/http";
import {ApiService} from "../../services/api.service";

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  public form: FormGroup;
  public error: string;
  public currentClient: Client;
  public fragment: string;
  public hostUser: string;
  public message: string = "";
  public initPassWord: boolean;
  public formInit: FormGroup;
  public messageOK: string= "";
  public passworEnvoye: boolean;

  constructor(private fb: FormBuilder, private clientService: ClientService, private router: Router
    , private autheService: AuthenticationService, private route: ActivatedRoute
    , private htttpClient: HttpClient, private hostTestService: ApiService) {
    this.hostUser = hostTestService.USERS_MICRO_APP;
  }

  ngOnInit(): void {
    this.form = this.fb.group(
      {
        username: [''],
        password: ['']
      }
    );
    this.formInit = this.fb.group(
      {
        mail: ['']
      }
    );
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
    } catch (e) {
    }
  }


  public subnit() {
    this.clientService.signin(this.form.value).subscribe(() => {

    })
  }


  public userConnect() {


    return this.htttpClient.post<Client>(this.hostUser + "/signin", this.form.value).subscribe(userConnect => {
        this.router.navigate(['/']);
        this.autheService.clientConnect(userConnect);


    },error => {
      this.message="Erreur de connection";
    })
  }

  reInitPass() {
    this.initPassWord=!this.initPassWord;
    this.messageOK="";
    this.message="";
    this.passworEnvoye=false;
  }
  initPass(){
    return this.htttpClient.get<Boolean>(this.hostUser + "/generatePassword/"+this.formInit.value.mail).subscribe(pass => {
    },error => {
      if (error.status==200){
        this.messageOK="Un nouveau mot de passe a été envoyé par mail";
        this.passworEnvoye=true;
        this.formInit.reset();
      }else {
      this.message="Erreur de connection";}
    })
  }
}
