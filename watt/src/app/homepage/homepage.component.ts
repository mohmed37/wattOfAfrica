import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../services/authentication.service";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
public photoPortrait:string="assets/img/work.jpg";
public photoblock1:string="assets/img/photo1.jpg";
public photoblock2:string="assets/img/photo2.jpg";
public photoblock3:string="assets/img/photo3.jpg";
public portraits:string="assets/img/portraits3.jpg";
  constructor(private autheService:AuthenticationService) { }

  ngOnInit(): void {


  }

}
