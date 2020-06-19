import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ClientService} from "../../services/client.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/authentication.service";
import {Client} from "../../model/client.model";

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  public form: FormGroup;
  public error:string;
  public currentClient : Client;

  constructor(private fb: FormBuilder,private clientService: ClientService, private router: Router
              ,private autheService:AuthenticationService) { }

  ngOnInit(): void {
    this.form = this.fb.group(
      {
        email:[''],
        password:['']
      }
    );
  }
  public subnit(){
   this.clientService.signin(this.form.value).subscribe(()=>{
     this.router.navigate(['/']);
   })
  }


  onLogin(dataForm: any) {
    this.autheService.isUserLoggedIn(dataForm.username,dataForm.password);

    if (this.autheService.isAuthenticated){
      this.autheService.saveAuthenticateurUser();
      this.router.navigateByUrl('/new-client');
    }
console.log(dataForm.password);
    console.log(dataForm.username);

  }

  public userConnect():void {
    console.log(this.form.value)
    this.clientService.clientConnect(this.form.value)}

    }
