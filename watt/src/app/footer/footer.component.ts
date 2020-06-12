import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ClientService} from "../services/client.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
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
