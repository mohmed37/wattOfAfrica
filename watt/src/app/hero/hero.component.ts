import { Component, OnInit } from '@angular/core';
import {BndreamService} from "../services/bndream.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {ClientService} from "../services/client.service";
import {AuthenticationService} from "../services/authentication.service";
import {QuestionnairesModel} from "../model/questionnaires.model";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ListHeroModel} from "../model/listHero.model";
import {MatRadioChange} from "@angular/material/radio";
import {MatCheckboxChange} from "@angular/material/checkbox";
import {ResultatHeroModel} from "../model/resultatHero.model";
import {Questionnaire4Model} from "../model/questionnaire4.model";

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.css']
})
export class HeroComponent implements OnInit {
  public userId: number | any;
  public questionnaires: QuestionnairesModel;
  public listValeurHero: ListHeroModel[];
  public qcm4Valide: boolean = false;
  public heroValide: boolean = false;
  public photoHero: string = "assets/img/hero.jpg";
  public form = new FormControl(false, Validators.required);
  formHero: FormGroup;
  listValeurClient: string[] = [];
  public resultatHero=new ResultatHeroModel();
  public hostTest: string = "http://localhost:9004/microservice-tests";
  message: string;
  constructor(private bndreamService: BndreamService, private router: Router, private httpClient: HttpClient,
              private serviceClient: ClientService, private userConnect: AuthenticationService) {
    this.userId = this.userConnect.userAuthenticated.num;
  }


  ngOnInit(): void {
    this.formHero = new FormGroup({
      hero: new FormControl('', Validators.required),
    });

    this.serviceClient.getQuestionnaires()
      .subscribe(data => {
        this.questionnaires = data;
        this.qcm4Valide = this.questionnaires.qcm4;
        this.heroValide = this.questionnaires.hero;
      }, error => {
        console.log(error);
      });
    this.bndreamService.getListHero()
      .subscribe(data => {
        this.listValeurHero = data;
      })
    this.bndreamService.getResultHero().subscribe(
      data =>{
        this.resultatHero=data;
      }
    );


  }

  onChange(event: MatCheckboxChange) {
    if (event.source.checked) {
      this.listValeurClient.push(event.source.value);
    }
    if (!event.source.checked) {
      for (let i = 0; i < this.listValeurClient.length; i++) {
        if (this.listValeurClient[i] == event.source.value) {
          this.listValeurClient = this.listValeurClient.filter(item => item !== event.source.value);
        }
      }
    }
  }

  saveHero() {
    this.resultatHero.valeur=this.listValeurClient;
    this.resultatHero.choixHero=this.formHero.value.hero;
    this.resultatHero.client=this.userId;
    this.bndreamService.saveHero(this.hostTest+ "/saveHeroClient/",this.resultatHero)
      .subscribe(res=>{
        this.serviceClient.putQuestionnaires("hero");
        this.router.navigateByUrl("/BnDeamTest");

      }, error => {
        this.message = "l'enregistrement à échoué!";
        console.log(error)
      });
  }
}
