import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cv-expert',
  templateUrl: './cv-expert.component.html',
  styleUrls: ['./cv-expert.component.css']
})
export class CvExpertComponent implements OnInit {
public photoExpert:string="assets/img/cvexpert2.png";
  public photoExpert2:string="assets/img/cvexpert1.png";
  public photoExpert3:string="assets/img/cvexpert3.jpg";
  public photoExpert4:string="assets/img/cvexpert4.jpg";
  public photoExpert5:string="assets/img/cvexpert5.jpg";
  constructor() { }

  ngOnInit(): void {
  }

}
