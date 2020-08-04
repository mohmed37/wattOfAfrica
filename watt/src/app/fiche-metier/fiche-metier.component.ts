import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {BndreamService} from "../services/bndream.service";
import {TexteModel} from "../model/texte.model";
import {FicheMetierService} from "../services/fiche-metier.service";

@Component({
  selector: 'app-fiche-metier',
  templateUrl: './fiche-metier.component.html',
  styleUrls: ['./fiche-metier.component.css']
})
export class FicheMetierComponent implements OnInit {
  public hostTest: string = "http://localhost:9004/microservice-tests";
  imageId: number;
  retrieveResonse: any;
  base64Data: any;
  retrievedImageFicheMetier: any;
  public allPhotoFicheMetier:any;
  public FicheMetier: any;
  public idFicheMetier: number;
  public metier: string;
  public competence:string;
  public competences:string[];
  public  qualite:string;
  public qualites:string[];
  public texte:string;
  public code:string;
  public newTexte=new TexteModel();
  constructor(private httpClient: HttpClient, private router: Router,private serviceBnDream:BndreamService,private ficheMetierService:FicheMetierService) {
  }

  ngOnInit(): void {

    this.getAllFicheMetier()
  }


  getImageFicheMeier() {
    this.ficheMetierService.ficheMetierByImage(this.imageId)
      .subscribe(
        res => {
          this.retrieveResonse = res;
          this.base64Data = this.retrieveResonse.picByte;
          this.retrievedImageFicheMetier = 'data:image/jpeg;base64,' + this.base64Data;
        }
      );
  }
  getAllFicheMetier() {
    this.ficheMetierService.ficheMetierAll()
      .subscribe(
        res => {
          this.allPhotoFicheMetier=res;

        }
      );
  }
  getFicheMetier() {

    this.ficheMetierService.ficheMetier(this.idFicheMetier)
      .subscribe(
        res => {
          this.FicheMetier=res;
          this.imageId=this.FicheMetier.photo.id;
          this.metier=this.FicheMetier.metier;
          this.competence=this.FicheMetier.competence;
          this.competences=this.split(this.competence);
          this.code=this.FicheMetier.code;
          this.qualite=this.FicheMetier.qualite;
          this.qualites=this.split(this.qualite);
          this.texte=this.FicheMetier.texte;
          console.log(this.imageId);
          this.getImageFicheMeier()
        }
      );
  }
split(phrase:string){

  return phrase.split("-");

}


}

