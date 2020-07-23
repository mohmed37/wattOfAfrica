import { Component, OnInit } from '@angular/core';
import {ClientService} from "../services/client.service";
import {QuestionnairesModel} from "../model/questionnaires.model";
import {ChartType, ChartOptions, ChartDataSets} from 'chart.js';
import { Label } from 'ng2-charts';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ChangeEvent} from "@ckeditor/ckeditor5-angular";
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import {RoueDeLaVieModel} from "../model/roueDeLaVie.model";
import {AuthenticationService} from "../services/authentication.service";
import {BndreamService} from "../services/bndream.service";
import {Router} from "@angular/router";
import {PhotoLangageModel} from "../model/photoLangage.model";



@Component({
  selector: 'app-roue-vie',
  templateUrl: './roue-vie.component.html',
  styleUrls: ['./roue-vie.component.css']
})
export class RoueVieComponent implements OnInit {
  public data: (any | number)[];
  public data1: (any | number)[];
  public data2: (any | number)[];

  constructor(private router:Router,private clientService:ClientService,private userConnect:AuthenticationService,private bndreamService:BndreamService) {
   this.userId=this.userConnect.userAuthenticated.num;
  }
  public roueVie: boolean=false;
  public questionnaires:QuestionnairesModel;
  public photolangage:boolean=false;
  public personnelle:number=0;
  public sante:number=0;
  public famille:number=0;
  public professionne:number=0;
  public social:number=0;
  public formRoueDeLAvie:FormGroup;
  public newNumber:number;
  public roueVie1: boolean=false;
  public roueVie2: boolean=false;
  public guandhi: string="assets/img/gandhi.jpg";
  public Editor = ClassicEditor;
  public  roueDeLaVie=new RoueDeLaVieModel( "<ol ><li>- - - - - - - - - - - - - - .</li>"+
    "<li>- - - - - - - - - - - - - - .</li>"+
    "<li>- - - - - - - - - - - - - - .</li></ol>","<ol ><li>- - - - - - - - - - - - - - .</li>"+
    "<li>- - - - - - - - - - - - - - .</li>"+
    "<li>- - - - - - - - - - - - - - .</li></ol>","<ol ><li>- - - - - - - - - - - - - - .</li>"+
    "<li>- - - - - - - - - - - - - - .</li>"+
    "<li>- - - - - - - - - - - - - - .</li></ol>");
  public resultroueDeLaVie:RoueDeLaVieModel;
  public userId:number;
  message: string;
  public modifier: boolean=false;
  public arret:  boolean=false;
  public   prioriser: boolean=false;
  public hostTest: string = "http://localhost:9004/microservice-tests";
    onSaveRoueDeLAvie() {
    this.roueDeLaVie.famille1=this.formRoueDeLAvie.value.famille;
    this.roueDeLaVie.famille2=this.formRoueDeLAvie.value.famille2;
    this.roueDeLaVie.personnelle1=this.formRoueDeLAvie.value.personnelle;
    this.roueDeLaVie.personnelle2=this.formRoueDeLAvie.value.personnelle2;
    this.roueDeLaVie.professionnel1=this.formRoueDeLAvie.value.professionne;
    this.roueDeLaVie.professionnel2=this.formRoueDeLAvie.value.professionne2;
    this.roueDeLaVie.sante1=this.formRoueDeLAvie.value.sante;
    this.roueDeLaVie.sante2=this.formRoueDeLAvie.value.sante2;
    this.roueDeLaVie.social1=this.formRoueDeLAvie.value.social1;
    this.roueDeLaVie.social2=this.formRoueDeLAvie.value.social2;
    this.roueDeLaVie.client=this.userId;
    this.questionnaires.roueVie=true;

     console.log(this.roueDeLaVie);
      this.bndreamService.saveRoueDeLaVie(this.hostTest+ "/saveRoueVieClient/",this.roueDeLaVie)
        .subscribe(res=>{
          this.clientService.putQuestionnaires("roueDeLaVie");
          this.prioriser=true;
          this.router.navigateByUrl("/BnDeamTest");

        }, error => {
          this.message = "l'enregistrement à échoué!";
          console.log(error)
        })


  }
    ngOnInit(): void {
      this.clientService. getQuestionnaires()
        .subscribe(data=>{
          this.questionnaires=data;
          this.roueVie=this.questionnaires.roueVie;
          this.photolangage=this.questionnaires.photoLangage;
        },error => {
          console.log(error);
        });
    this.formRoueDeLAvie=new FormGroup({
      personnelle:new FormControl('',Validators.required),
      sante:new FormControl('',Validators.required),
      famille:new FormControl('',Validators.required),
      social1:new FormControl('',Validators.required),
      professionne:new FormControl('',Validators.required),
      personnelle2:new FormControl('',Validators.required),
      sante2:new FormControl('',Validators.required),
      famille2:new FormControl('',Validators.required),
      social2:new FormControl('',Validators.required),
      professionne2:new FormControl('',Validators.required),
    });

      this.bndreamService.getResultRoueDeLaVie().subscribe(
        data =>{
          this.resultroueDeLaVie=data;
        this.data1=[this.resultroueDeLaVie.personnelle1,this.resultroueDeLaVie.sante1,this.resultroueDeLaVie.famille1
          ,this.resultroueDeLaVie.professionnel1,this.resultroueDeLaVie.social1];
          this.pieChartData1[0].data=this.data1;
         this.data2=[this.resultroueDeLaVie.personnelle2,this.resultroueDeLaVie.sante2,this.resultroueDeLaVie.famille2
           ,this.resultroueDeLaVie.professionnel2,this.resultroueDeLaVie.social2];
          this.pieChartData2[0].data=this.data2;
        }
      );

     }


  public pieChartOptions: ChartOptions = {
    responsive: true,
    legend: {

    },
    plugins: {
      datalabels: {
        formatter: (value, ctx) => {
          const label = ctx.chart.data.labels[ctx.dataIndex];
          return label;
        },
      },
    }
  };
  public pieChartLabels: Label[] = ['La vie personnelle','La santé ', 'La famille ', 'Le professionnel ', 'Le social '];
  public pieChartData: ChartDataSets[] = [{data:[1,1,1,1,1]}];
  public pieChartData1: ChartDataSets[]=[{data:[]}];
  public pieChartData2: ChartDataSets[]=[{data:[]}];
  public pieChartType: ChartType = 'pie';
  public pieChartLegend = true;
  public pieChartPlugins ;
  public pieChartColors = [
    {
      backgroundColor: [ 'rgba(193, 28, 199, 1)',
        'rgba(29, 4, 255,1)',
        'rgba(25,193 ,13, 1)',
        'rgba(255, 213, 4, 1)',
        'rgba(255, 4, 4, 1)',],
    },
  ];








  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }


  changeLegendPosition() {
    this.pieChartOptions.legend.position = this.pieChartOptions.legend.position === 'left' ? 'top' : 'left';
  }




  onChange(categorie:string,value):void  {

    switch (categorie) {
      case "personnelle":
        this.personnelle=value;
        break;
      case "sante":
        this.sante=value;
        break;
      case "famille":
        this.famille=value;
        break;
      case "professionne":
        this.professionne=value;
             break;
      case "social":
        this.social=value;
        break;
    }
    this.data = [
      this.personnelle,this.sante,this.famille,this.professionne,this.social];
    this.pieChartData[0].data=this.data;

  }

  init() {
    this.data  = [1,1,1,1,1];
    this.pieChartData[0].data=this.data;
    this.roueVie1=true;
  }

  onChange3({ editor }: ChangeEvent,theme:string) {
    switch (theme) {
      case "modifier":
        this.roueDeLaVie.qcm1=editor.getData();
        break;
      case "arret":
        this.roueDeLaVie.qcm2=editor.getData();
        break;
      case "prioriser":
        this.roueDeLaVie.qcm3=editor.getData();
        break;
      default:
        return null;
    }
  }

  roueDeLaVie2() {
    this.roueVie2=true;
  }

  editor(theme:string) {
    switch (theme) {
      case "modifier":
        this.modifier=true;
        break;
      case "arret":
        this.arret=true;
        break;
      default:
        return null;
    }

  }


}
