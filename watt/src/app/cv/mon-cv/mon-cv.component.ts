import {Component, Input, OnInit} from '@angular/core';
import {CvModel} from "../../model/cv.model";
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { ChangeEvent } from '@ckeditor/ckeditor5-angular/ckeditor.component';
import {HttpClient,HttpEventType} from "@angular/common/http";
import {ClientService} from "../../services/client.service";
import {AuthenticationService} from "../../services/authentication.service";
import {ListMetierClientModel} from "../../model/listMetierClient.model";
import {Bnbecome} from "../../services/bnbecome.service";
import {FicheMetier} from "../../model/ficheMetier.model";

@Component({
  selector: 'app-mon-cv',
  templateUrl: './mon-cv.component.html',
  styleUrls: ['./mon-cv.component.css']
})
export class MonCvComponent implements OnInit {
public currentCv:CvModel=new CvModel("LAURA MONTREUIL"," ASSISTANTE DE DIRECTION","<h4>Accueil et communication :</h4>"+
  "<ul><li>Accueil téléphonique et physique de la clientèle</li>"+
  "<li>Traiter l'information et orienter les clients vers le bon interlocuteur</li>" +
  "<li>Relance client et gestion de la relation SAV</li>"+
  "<li>Assurer la transmission des informations en interne et en externe (décisions, notes...) </li>"+
  "<li>Contribuer à la mise en œuvre d'actioons de communications</li>"+
  "<li>Communiquer à l'écrit et à l'oral en français et en anglais</li></ul>"+
  "<h4>Administratif et gestion :</h4>"+
  "<ul><li>Saisir des documents numériques</li>"+
  "<li>Réaliser les commandes de matériel, de fournitures, de consommables et vérifier la conformité des livraisons</li>" +
  "<li>Rédiger les devis, conventions et factures </li>" +
  "<li>Actualiser la documentation professionnelle et réglementaire</li>" +
  "<li>Veille informatique et réglementaire</li>\n" +
  "<li>Contribuer à la gestion administrative des RH</li>" +
  "<li>Connaissances sur Photoshop, Première pro et Sony Vegas Pro (retouches photos, montage vidéo)</li></ul>"+
  "<h4>Compétences linguistiques :</h4>"+
  "<ul ><li> Arabe : Niveau C2</li>"+
  "<li>Français : Niveau C1</li>"+
  "<li>Anglais : Niveau B2</li></ul>"+
  "<h4>Mobilité :</h4>"+
  "<ul ><li>Permis B et véhiculée</li>"+
  "<li>Mobilité départementale / régionale / nationale / internationale</li>"+
  "<li>En cours de mobilité à Alger</li></ul>"+
  "<h4>Accomplissements / Centres d'interêt :</h4>"+
  "<ul ><li>Sport pratiqué -  Loisirs (lecture, cinéma, jeux vidéo…) – Passions – Engagement associatif </li></ul>"," <h4>Vendeuse polyvalente événementiel</h4>"+
  "<p>SOLARY PRODUCTION À TOURS</p>"+
  "<p>Diverses missions accomplies en 2019 lors d'évènements gaming et E-sportif tels que la Paris Games Week</p>"+
  "<h4>Entraineur de gymnastique artistique</h4>"+
  "<p>AS CHANCEAUX GYMNASTIQUE À CHANCEAUX SUR CHOISILLE</p>"+
  "<p>En formation BPJEPS de Septembre 2018 à février 2019</p>"+
  "<h4>Assistante de direction</h4>"+
  "<p>ALPMA FRANCE À LANGEAIS</p>"+
  "<p>En contrat d'apprentissage d'octobre 2017 à avril 2018</p>"+
  "<h4>Employée polyvalente</h4>"+
  "<p>MCDONALD'S À AMIENS</p>"+
  "<p>Janvier à Juin 2017</p>"+
  "<p>QUICK À AMIENS </p>"+
  "<p>Octobre 2014 à Mars 2016 en contrat étudiant</p>"+
  "<h4>Femme de chambre</h4>"+
  "<p>MISTER BED À RANG-DU-FLIERS (62)</p>"+
  "<p>En août 2013, contrat saisonnier</p>"," <h4>ASSISTANTE DE DIRECTION</h4>"+
  "<p>LANGUES ETRANGERES APPLIQUEES</p>\n" +
  "<p>PREMIÈRE ANNÉE UPJV AMIENS EN 2016</p>" +
  "<p>Anglais et Italien</p>" +
  "<h4>BACCALAUREAT LITTERAIRE</h4>" +
  "<p>LYCÉE JAN LAVEZZARI  EN 2014</p>" +
  "<p>Option droit et grands enjeux du monde contemporain</p>","<ul><li>1 rue de la chambrerie, 37100 TOURS</li></ul>",
  "<ul><li>laura.montreuil@hotmail.fr</li></ul>","<ul><li>06.74.76.96.36</li></ul>","assets/img/portrai.jpg");

public modifNom:boolean=false;
public modifMetier: boolean=false;
public  modifCom: boolean=false;
public modifProf: boolean = false;
public modifPhoto:boolean=false;
public modifAdmin: boolean;
public  modifDiplom: boolean=false;
public  modifAdresse: boolean=false;
public  modifMail: boolean=false;
public  modifPhone: boolean=false;
public  bouttonActif: boolean=false;
public  bouttonActif2: boolean=false;
public  bouttonActif3: boolean=false;
public  bouttonActif4: boolean=false;
public  bouttonActif5: boolean=false;
public bouttonActif6:boolean=false;
 public userId: number | any;
cheminImage : string = "/assets/img/portrai.jpg";
fileToUpload : File= null;
  public colorBotton2: string="#bdc3c7";
  public colorBotton1: string="#bdc3c7";
  public userConnectClient:boolean;
  public ficheClient:ListMetierClientModel;
  public metierValide:any[]=[];
  listByMetierSelect:FicheMetier[]=[];
  public metier:any[]=[];


  constructor(private http: HttpClient,private clientService:ClientService, private userConnect:AuthenticationService
              ,private bnbecome:Bnbecome) {
    if (userConnect.userAuthenticated){
    this.userConnectClient=userConnect.userAuthenticated;}
  }
  public Editor = ClassicEditor;
  public nomClient2;
 public nomClient:string;
 public premomClient:string;

  ngOnInit(): void {
    if (this.userConnect.userAuthenticated){
   this.nomClient=this.userConnect.userAuthenticated.nom;
   this.premomClient=this.userConnect.userAuthenticated.prenom;
    this.listFicheMetierClient();}

  }
  public onReady( editor ) {
    editor.ui.getEditableElement().parentElement.insertBefore(
      editor.ui.view.toolbar.element,
      editor.ui.getEditableElement()
    );
  }

  maxlength(e){
    if (e.editor.getTotalLength()>500){
      e.editor.deleteText(500,e.editor.getLength());
    }
  }

  onChange({ editor }: ChangeEvent) {
    if (this.modifCom){
    this.currentCv.competence = editor.getData();}
    if (this.modifMetier){
      this.currentCv.metier = editor.getData();}
    if (this.modifNom){
      this.currentCv.nom = editor.getData();}
    if (this.modifAdmin){
      this.currentCv.administration = editor.getData();}
    if (this.modifProf){
      this.currentCv.experience = editor.getData();}
    if (this.modifDiplom){
      this.currentCv.diplome = editor.getData();}
    if (this.modifAdresse){
      this.currentCv.adresse = editor.getData();}
    if (this.modifMail){
      this.currentCv.mail = editor.getData();}
    if (this.modifPhone){
      this.currentCv.mobile = editor.getData();}
    if (this.modifPhoto){
      this.cheminImage = editor.getData();}
  }



  modif(current:string) {

    if (current==="metier"){
      this.bouttonActif =!this.bouttonActif;
      this.modifMetier =! this.modifMetier;}
    if (current==="nom"){
      this.bouttonActif =!this.bouttonActif;
      this.modifNom =! this.modifNom;}
    if (current==="competences") {
      this.bouttonActif2 =! this.bouttonActif2;
      this.modifCom =!this.modifCom; }
    if (current==="experience") {
      this.bouttonActif3 =!this.bouttonActif3;
      this.modifProf =! this.modifProf; }
    if (current==="diplomes") {
      this.bouttonActif4 =! this.bouttonActif4;
      this.modifDiplom = ! this.modifDiplom; }
    if (current==="adresse") {
      if(!this.modifMail&&!this.modifPhone){
      this.bouttonActif5 =!this.bouttonActif5;}
      this.modifAdresse =!this.modifAdresse; }
    if (current==="mail") {
      if(!this.modifAdresse&&!this.modifPhone){
      this.bouttonActif5 =!this.bouttonActif5;}
      this.modifMail=! this.modifMail; }
    if (current==="phone") {
      if(!this.modifAdresse&&! this.modifMail){
      this.bouttonActif5 = !this.bouttonActif5 ;}
      this.modifPhone =!this.modifPhone; }
    if (current==="photo") {
      this.bouttonActif6 =! this.bouttonActif6 ;
      this.modifPhoto = !this.modifPhoto; }
  }

  finModif(){
    this.bouttonActif = false;
    this.bouttonActif2 = false;
    this.bouttonActif3 = false;
    this.bouttonActif4 = false;
    this.bouttonActif5 = false;
    this.bouttonActif6 = false;
    this.modifPhoto = false;
    this.modifNom = false;
    this.modifMetier = false;
    this.modifCom =  false;
    this.modifAdmin = false;
    this.modifProf =  false;
    this.modifDiplom =  false;
    this.modifAdresse =  false;
    this.modifMail=  false;
    this.modifPhone =  false;
    this.modifPhone = false;
  }
selectedFile=null;
 public newImage:string;
  public colorNew:string="pink";
  public colorNew2:string="#1f46c1";
  public colorNewText:string="#1f46c1";
  public colorNewTextNom:string= "pink";
  public colorNewTextMetier:string= "#ffffff";

  onFileSelected(event) {
    console.log(event);
    this.selectedFile=event.target.files[0];
    this.newImage=event.target.value;
  }



  handleFinInput(file: FileList) {
    console.log(file);
     this.fileToUpload = file.item(0);
    var reader = new FileReader();
    reader.onload= (ev:any) => {
      this.cheminImage = ev.target.result;
    };
    reader.readAsDataURL(this.fileToUpload);
  }


  changeColor() {

    switch (this.colorNew) {
      case 'pink':
        this.colorBotton1="#1f46c1";
        this.colorNew = "#bdc3c7";
        this.colorNewText = "#1f46c1";
        break;
      case '#bdc3c7':
        this.colorBotton1="pink";
        this.colorNew = "#1f46c1";
        this.colorNewText = "#ffffff";
        break;
      case '#1f46c1':
        this.colorBotton1="#bdc3c7";
        this.colorNew = "pink";
        this.colorNewText = "#1f46c1";
        break;

      default:
        this.colorBotton1="#bdc3c7";
        this.colorNew = "pink";
        this.colorNewText = "#1f46c1";
    }

  }

  changeColor2() {

    switch (this.colorNew2) {
      case '#1f46c1':
        this.colorBotton2="pink";
        this.colorNew2 = "#bdc3c7";
        this.colorNewTextNom="#1f46c1";
        this.colorNewTextMetier = "#1f46c1";

        break;
      case '#bdc3c7':
        this.colorBotton2="#1f46c1";
        this.colorNew2 = "pink";
        this.colorNewTextNom="#1f46c1";
        break;
      case 'pink':
        this.colorBotton2="#bdc3c7";
        this.colorNew2= "#1f46c1";
        this.colorNewTextNom="#ffffff";
        this.colorNewTextMetier = "#ffffff";

        break;
      default:
        this.colorBotton2="#bdc3c7";
        this.colorNew2 = "#1f46c1";
        this.colorNewText = "#ffffff";
        this.colorNewTextMetier = "#ffffff";
    }
  }

  listFicheMetierClient(){
    this.bnbecome.getFicheMetierClient().subscribe(
      data=>{
        this.ficheClient=data;
        this.ficheClient.valide.forEach(ficheMetierValide=>{
          if(ficheMetierValide.etat==true){
            this.metierValide.push(ficheMetierValide)
          }
        });
        this.ficheClient.ficheMetiers.forEach(ficheMetier=>{
          let id=ficheMetier.id;
          this.metierValide.forEach(ficheMetierNewValide=>{
            if (ficheMetierNewValide.id==id){
              this.metier.push(ficheMetier);

            }
          });
        });
        this.getMetierSelection(this.metierValide,this.ficheClient);

      },error => {
        console.log(error);
      });

  }
  getMetierSelection(metierValide: any[], ficheClient: ListMetierClientModel){
    metierValide.forEach(ficheMetierValide=>{
      if(ficheMetierValide.selection==true){
        ficheClient.ficheMetiers.forEach(ficheMetier=>{
          if (ficheMetier.id==ficheMetierValide.id){
            this.listByMetierSelect.push(ficheMetier);
          }
        })
      }
    });
  }


}
