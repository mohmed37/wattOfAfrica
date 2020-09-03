import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {BndreamService} from "../../services/bndream.service";
import {TexteModel} from "../../model/texte.model";
import {FicheMetierService} from "../../services/fiche-metier.service";
import {FicheMetier} from "../../model/ficheMetier.model";

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
  retrievedImage: any;
  public allPhotoFicheMetier=[];
  public photoFicheMetier=[];
  public FicheMetier:FicheMetier;
  public idFicheMetier: number;
  public metier: string;
  public competence:string;
  public competences:string[];
  public  qualite:string;
  public qualites:string[];
  public texte:string;
  public code:string;
  public newTexte=new TexteModel();
  public ListQuestionnaire:any[];

  constructor(private httpClient: HttpClient, private router: Router,private serviceBnDream:BndreamService,private ficheMetierService:FicheMetierService) {
  }
  @Output() public pick:EventEmitter<number>=new EventEmitter<number>();
  public idCarrousel:number=1;
  public photoCarrousel: any;
  public listImageFicheMetier=[];
  public metierDico:string;
  public selectFicheMetierValide: boolean;
  public selecMetier: boolean;
  public listMetierDico=[];
  public ficheCaroussel:FicheMetier[];
  public fichedetail: boolean;

  ngOnInit(): void {

    this.getAllFicheMetier();

  }


  getImageFicheMeier(idCarrousel) {
    this.ficheMetierService.ficheMetierByImage(idCarrousel)
      .subscribe(
        res => {
          this.retrieveResonse = res;
          this.base64Data = this.retrieveResonse.picByte;
          this.photoCarrousel = 'data:image/jpeg;base64,' + this.base64Data;
          this.photoFicheMetier.push(this.retrievedImageFicheMetier);
          this.metierDico=this.retrieveResonse.name;
        }

      );

  }
  getAllFicheMetier() {
    this.ficheMetierService.ficheMetierAll()
      .subscribe(
        res => {
          this.allPhotoFicheMetier=res;
          this.page("=");
        }
      );
  }
  getFicheMetier() {

    this.ficheMetierService.ficheMetier(this.idFicheMetier)
      .subscribe(
        res => {
          this.FicheMetier=res;
          this.metier=this.FicheMetier.metier;
          this.competence=this.FicheMetier.competence;

          this.competences=this.split(this.competence);
          console.log(this.competences);
          this.code=this.FicheMetier.code;
          this.qualite=this.FicheMetier.qualite;
          this.qualites=this.split(this.qualite);
          this.texte=this.FicheMetier.texte;
          this.getImageFicheMeier(this.FicheMetier.photo.id)
        }
      );
  }
split(phrase:string){

  return phrase.split("-");

}


  page(s: string) {
    this.selecMetier=false;
    this.fichedetail=false;
    this.selectFicheMetierValide=false;
    if (s=='+'&&this.idCarrousel<this.allPhotoFicheMetier.length-1){
      this.idCarrousel=this.idCarrousel+1;
      this.getImageFicheMeier(this.idCarrousel);
    }
    if (s=='-'&&this.idCarrousel>0){
      this.idCarrousel=this.idCarrousel-1;
      this.getImageFicheMeier(this.idCarrousel);
    }else {
      this.getImageFicheMeier(this.idCarrousel);
    }
  }

  clic(idCarrousel: number) {
    this.ficheMetierService.ficheMetierByPhotoId(idCarrousel)
      .subscribe(
        res => {
          this.ficheCaroussel=res;
          this.selecMetier=true;

        });

  }

  selectFicheMetier(id: any) {
    this.ficheMetierService.ficheMetier(id)
      .subscribe(
        res => {
          this.FicheMetier=res;
          this.competences=this.split(this.FicheMetier.competence);
          this.qualites=this.split(this.FicheMetier.qualite);
          this.fichedetail=true;
        })
  }
}
