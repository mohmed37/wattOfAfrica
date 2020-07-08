import { Component, OnInit } from '@angular/core';
import {ClientService} from "../services/client.service";
import {Router} from "@angular/router";
import {BndreamService} from "../services/bndream.service";
import {HttpClient} from "@angular/common/http";
import { FormControl, FormGroup,Validators } from '@angular/forms';
import {PhotoLangageModel} from "../model/photoLangage.model";
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import {ChangeEvent} from "@ckeditor/ckeditor5-angular";
import {QuestionnairesModel} from "../model/questionnaires.model";
import {AuthenticationService} from "../services/authentication.service";
@Component({
  selector: 'app-photolangage',
  templateUrl: './photolangage.component.html',
  styleUrls: ['./photolangage.component.css']
})
export class PhotolangageComponent implements OnInit {

  public hostTest: string = "http://localhost:9004/microservice-tests";
  public retrieveResonseAll: any;
  public dedutTestPhotolangage: boolean=false;

  constructor(private bndreamService:BndreamService, private router:Router,private httpClient: HttpClient,private serviceClient:ClientService, private userConnect:AuthenticationService) { }
  base64Data: any;
  message: string;
  public photos:any;
  public size:number=4;
  public currentPage:number=0;
  public  totalPage:number;
  public  pages:Array<number>;
  imageId1:number=1;
  imageId2:number=2;
  imageId3:number=3;
  imageId4:number=4;
  imageId5:number=5;
  public idPhoto:Array<number>;
  retrieveResonse1: any;
  retrieveResonse2: any;
  retrieveResonse3: any;
  retrieveResonse4: any;
  retrieveResonse5: any;
  retrievedImage1: any;
  retrievedImage2: any;
  retrievedImage3: any;
  retrievedImage4: any;
  retrievedImage5: any;
  retrievedImageClient1:any=null;
  retrievedImageClient2:any=null;
  retrievedImageClient3:any=null;
  retrieveResonseChoix:any=null;
  mot1:boolean=false;
  mot2:boolean=false;
  mot3:boolean=false;
  partie1:boolean=false;
  partie2:boolean=false;
  partie3:boolean=false ;
  public formPhotoLangage: FormGroup;
  retrievedImageClient4:any=null;
  retrievedImageClient5:any=null;
  retrievedImageClient6:any=null;
  mot4:boolean=false;
  mot5: boolean=false;
  mot6: boolean=false;
  idImageSelect:any;
  public photoLangage=new PhotoLangageModel();
  public questionnaires=new QuestionnairesModel() ;
  public Editor = ClassicEditor;
  public resultPhotoLangage:PhotoLangageModel;
  public listPhoto=[];
  public photolangageValide:boolean=false;
  public choixMot1:string;
  public choixMot2:string;
  public choixMot3:string;
  public choixMot4:string;
  public choixMot5:string;
  public choixMot6:string;
  public texte:string;
  public questionnaires2:QuestionnairesModel;





  ngOnInit(): void {
    this.serviceClient. getQuestionnaires()
      .subscribe(data=>{
        this.questionnaires2=data;
        this.photolangageValide=this.questionnaires2.photoLangage;
      },error => {
        console.log(error);
      });
    this.formPhotoLangage=new FormGroup({
      mot1:new FormControl('',Validators.required),
      mot2:new FormControl('',Validators.required),
      mot3:new FormControl('',Validators.required),
      mot4:new FormControl('',Validators.required),
      mot5:new FormControl('',Validators.required),
      mot6:new FormControl('',Validators.required)

    });
    console.log(this.formPhotoLangage.value.mot2)
    this.bndreamService.getResultPhotoLangage()
      .subscribe(data=>{
        this.resultPhotoLangage=data;
        this.listPhoto.push(this.resultPhotoLangage.photo1);
        this.listPhoto.push(this.resultPhotoLangage.photo2);
        this.listPhoto.push(this.resultPhotoLangage.photo3);
        this.listPhoto.push(this.resultPhotoLangage.photo4);
        this.listPhoto.push(this.resultPhotoLangage.photo5);
        this.listPhoto.push(this.resultPhotoLangage.photo6);
        this.choixMot1=this.resultPhotoLangage.mot1;
        this.choixMot2=this.resultPhotoLangage.mot2;
        this.choixMot3=this.resultPhotoLangage.mot3;
        this.choixMot4=this.resultPhotoLangage.mot4;
        this.choixMot5=this.resultPhotoLangage.mot5;
        this.choixMot6=this.resultPhotoLangage.mot6;
        this.texte=this.resultPhotoLangage.expression;

        for (let i = 0; i < this.listPhoto.length; i++){
          this.photoClientChoix(this.listPhoto[i],i+1)
        }
        },error => {
        console.log(error);
      } );
  }

  getImageList(number: number) {
    switch (number) {
      case 1:
        this.imageId1 =this.imageId1+5 ;
        this.imageId2=this.imageId2+5 ;
        this.imageId3=this.imageId3+5 ;
        this.imageId4=this.imageId4+5 ;
        this.imageId5=this.imageId5+5 ;
        break;
      case 0:
        this.imageId1=this.imageId1-5 ;
        this.imageId2=this.imageId2-5 ;
        this.imageId3=this.imageId3-5 ;
        this.imageId4=this.imageId4-5 ;
        this.imageId5=this.imageId5-5 ;
        break;
      default:
        this.imageId1=1;
        this.imageId2=2;
        this.imageId3=3;
        this.imageId4=4;
        this.imageId5=5;
    }
    this.idPhoto=new Array<number>( this.imageId1,this.imageId2,this.imageId3,this.imageId4,this.imageId5);
    this.httpClient.get(this.hostTest +"/getAll/" + this.idPhoto)
      .subscribe(
        res => {
          this.retrieveResonse1 = res[0];
          this.base64Data = this.retrieveResonse1.picByte;
          this.retrievedImage1 = 'data:image/jpeg;base64,' + this.base64Data;
          this.retrieveResonse2 = res[1];
          this.base64Data = this.retrieveResonse2.picByte;
          this.retrievedImage2 = 'data:image/jpeg;base64,' + this.base64Data;
          this.retrieveResonse3 = res[2];
          this.base64Data = this.retrieveResonse3.picByte;
          this.retrievedImage3= 'data:image/jpeg;base64,' + this.base64Data;
          this.retrieveResonse4  = res[3];
          this.base64Data = this.retrieveResonse4.picByte;
          this.retrievedImage4 = 'data:image/jpeg;base64,' + this.base64Data;
          this.retrieveResonse5 = res[4];
          this.base64Data = this.retrieveResonse5.picByte;
          this.retrievedImage5 = 'data:image/jpeg;base64,' + this.base64Data;
        }
      );
  }



  testPhotolangage() {
    this.dedutTestPhotolangage=true;

  }

  imageClientChoix(imageId: number) {

    this.httpClient.get(this.hostTest +"/getId/"+imageId)
      .subscribe(
        res => {
          this.retrieveResonseChoix = res;
          this.base64Data = this.retrieveResonseChoix.picByte;
          this.idImageSelect=this.retrieveResonseChoix.name;

          if (this.partie1==false){
            if(this.retrievedImageClient3==null&&this.retrievedImageClient2!=null){
              this.retrievedImageClient3 = 'data:image/jpeg;base64,' + this.base64Data;
              this.photoLangage.photo3=this.idImageSelect;
              this.mot3=true;}
            if(this.retrievedImageClient2==null&&this.retrievedImageClient1 != null){
              this.retrievedImageClient2 = 'data:image/jpeg;base64,' + this.base64Data;
              this.photoLangage.photo2=this.idImageSelect;
              this.mot2=true; }
            if(this.retrievedImageClient1 == null){
              this.retrievedImageClient1 = 'data:image/jpeg;base64,' + this.base64Data;
              this.photoLangage.photo1=this.idImageSelect;
              this.mot1=true;}}
          if (this.partie1==true){
            if(this.retrievedImageClient6==null&&this.retrievedImageClient5!=null){
              this.retrievedImageClient6 = 'data:image/jpeg;base64,' + this.base64Data;
              this.photoLangage.photo6=this.idImageSelect;
              this.mot6=true;}
            if(this.retrievedImageClient5==null&&this.retrievedImageClient4 != null){
              this.retrievedImageClient5 = 'data:image/jpeg;base64,' + this.base64Data;
              this.photoLangage.photo5=this.idImageSelect;
              this.mot5=true; }
            if(this.retrievedImageClient4 == null){
              this.retrievedImageClient4 = 'data:image/jpeg;base64,' + this.base64Data;
              this.photoLangage.photo4=this.idImageSelect;
              this.mot4=true;}}
        }
      );}

  photoClientChoix(imageId: string, numberPhoto: number) {

    this.httpClient.get(this.hostTest +"/getId/"+imageId)
      .subscribe(
        res => {
          this.retrieveResonseChoix = res;
          this.base64Data = this.retrieveResonseChoix.picByte;
          this.idImageSelect=this.retrieveResonseChoix.name;

          if (numberPhoto==3){
              this.retrievedImageClient3 = 'data:image/jpeg;base64,' + this.base64Data;
             }
            if(numberPhoto==2){
              this.retrievedImageClient2 = 'data:image/jpeg;base64,' + this.base64Data;
             }
            if(numberPhoto==1){
              this.retrievedImageClient1 = 'data:image/jpeg;base64,' + this.base64Data;
             }
            if(numberPhoto==6){
              this.retrievedImageClient6 = 'data:image/jpeg;base64,' + this.base64Data;
             }
            if(numberPhoto==5){
              this.retrievedImageClient5 = 'data:image/jpeg;base64,' + this.base64Data;
              }
            if(numberPhoto==4){
              this.retrievedImageClient4 = 'data:image/jpeg;base64,' + this.base64Data;
              }
        }
      );}


  imageDeleteChoix(imageId: number) {
    if (imageId==1){
      this.retrievedImageClient1 = null;
      this.mot1=false;
      this.formPhotoLangage.patchValue({
        mot1:'',
      });
    }
    if (imageId==2){
      this.retrievedImageClient2 = null;
      this.mot2=false;
      this.formPhotoLangage.patchValue({
        mot2:'',
      });
    }
    if (imageId==3){
      this.retrievedImageClient3 = null;
      this.mot3=false;
      this.formPhotoLangage.patchValue({
        mot3:'',
      });
    }
    if (imageId==4){
      this.retrievedImageClient4 = null;
      this.mot4=false;
      this.formPhotoLangage.patchValue({
        mot4:'',
      });
    }
    if (imageId==5){
      this.retrievedImageClient5 = null;
      this.mot5=false;
      this.formPhotoLangage.patchValue({
        mot5:'',
      });
    }
    if (imageId==6){
      this.retrievedImageClient6 = null;
      this.mot6=false;
      this.formPhotoLangage.patchValue({
        mot6:'',
      });
    }


  }

  onSavePhotoLangage() {
    this.photoLangage.mot1=this.formPhotoLangage.value.mot1;
    this.photoLangage.mot2=this.formPhotoLangage.value.mot2;
    this.photoLangage.mot3=this.formPhotoLangage.value.mot3;
    this.photoLangage.mot4=this.formPhotoLangage.value.mot4;
    this.photoLangage.mot5=this.formPhotoLangage.value.mot5;
    this.photoLangage.mot6=this.formPhotoLangage.value.mot6;
    this.photoLangage.client=6;
    this.questionnaires.photoLangage=true;
      this.bndreamService.savePhotLangage(this.hostTest+ "/saveResultPhotoLangage/",this.photoLangage)
        .subscribe(res=>{
          console.log(res);
          this.onUpdateQuestionnaire("photolangage");
          this.router.navigateByUrl("/BnDeamTest");

        }, error => {
          this.message = "l'enregistrement à échoué!";
          console.log(error)
        })
    }

  validePartie1() {
    this.partie1=true;
  }

  validePartie2() {
    this.partie2=true;
  }



  onChange({ editor }: ChangeEvent) {
    this.photoLangage.expression=editor.getData();
  }

  onUpdateQuestionnaire(value: string) {
    this.serviceClient.putQuestionnaires(value)
      .subscribe(data=>{

      },error => {
        console.log(error)
      })

  }



}

