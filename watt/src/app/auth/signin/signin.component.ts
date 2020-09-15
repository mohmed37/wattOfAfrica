import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ClientService} from "../../services/client.service";
import {ActivatedRoute, Router} from "@angular/router";
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
  public fragment: string;

  constructor(private fb: FormBuilder,private clientService: ClientService, private router: Router
              ,private autheService:AuthenticationService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.form = this.fb.group(
      {
        email:[''],
        password:['']
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
    } catch (e) { }
  }



  public subnit(){
   this.clientService.signin(this.form.value).subscribe(()=>{

   })
  }



  public userConnect(){
    this.autheService.clientConnect(this.form.value);
    if (this.autheService.isAuthenticated){
      this.autheService.saveAuthenticateurUser();
      this.router.navigate(['/']);
    }

  }

}
