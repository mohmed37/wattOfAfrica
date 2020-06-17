import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ClientService} from "../../services/client.service";
import {Client} from "../../model/client.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public form: FormGroup;
  public error:string;
  public currentClient:Client;

  constructor(private fb: FormBuilder, private cleintService:ClientService,private router:Router) { }

  ngOnInit(): void {
    this.form = this.fb.group(
      {
        email:[''],
        nom:[''],
        password:[''],
        prenom:[''],
        phone:[''],
        date:[''],
        matchingPassword:[''],
        username:['']
      }
    );
  }
  public subnit():void {
    this.cleintService.signup(this.form.value).subscribe(
      res=>{
        this.currentClient=res;
      },error1 => {
        console.log(error1)
      }
    );
    this.router.navigate(['/signin']);
    console.log(this.form.value)
  }


}
