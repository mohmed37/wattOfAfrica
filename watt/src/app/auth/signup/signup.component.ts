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

  public color="red";
  public content="Mohamed";
  public displayButton= true;
  public colorNew="green";
  public colorNew2= "rouge";
  public users:Array<{nom:string}>=[
    {
      nom:"Mohamed"
    },
    {
      nom:"Mehdi"
    },
    {
      nom:"Anis"
    }
  ];

  constructor(private clientService:ClientService,private router:Router) { }

  ngOnInit(): void {
  }
  changeColor(newColor: string) {
    this.color=newColor;
    this.colorNew=newColor;
  }


}
