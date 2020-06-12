import { Component,HostBinding } from '@angular/core';
import {ClientService} from "./services/client.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'watt of Africa';
  constructor(private clientService:ClientService, private router:Router) { }


}
