import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import {NewClientComponent} from "./new-client/new-client.component";
import {ModifClientComponent} from "./modif-client/modif-client.component";
import {MonCvComponent} from "./mon-cv/mon-cv.component";
import {HomepageComponent} from "./homepage/homepage.component";
import {SignupComponent} from "./auth/signup/signup.component";
import {SigninComponent} from "./auth/signin/signin.component";
import {DefinitionComponent} from "./definition/definition.component";
import {BndreamComponent} from "./bndream/bndream.component";
import {BndreamTestComponent} from "./bndream-test/bndream-test.component";
import {PhotolangageComponent} from "./photolangage/photolangage.component";
import {RoueVieComponent} from "./roue-vie/roue-vie.component";
import {AutoportraitComponent} from "./autoportrait/autoportrait.component";
import {PraicoComponent} from "./praico/praico.component";
import {HeroComponent} from "./hero/hero.component";
import {AdministrateurComponent} from "./administrateur/administrateur.component";
import {FicheMetierComponent} from "./fiche-metier/fiche-metier.component";



const routes: Routes = [
  {

    path: 'ficheMetier',
    component: FicheMetierComponent
  },
  {

    path: 'admin',
    component: AdministrateurComponent
  },
  {
    path: 'hero',
    component: HeroComponent
  },
  {
    path: 'praico',
    component: PraicoComponent
  },
  {
    path: 'autoPortrait',
    component: AutoportraitComponent
  },
  {
    path: 'roue-de-la-vie',
    component: RoueVieComponent
  },
  {
    path: 'photolangage',
    component: PhotolangageComponent
  },
  {
    path: 'EnSavoirPlus',
    component: DefinitionComponent
  },
  {
    path: 'BnDeam',
    component: BndreamComponent
  },
  {
    path: 'BnDeamTest',
    component: BndreamTestComponent
  },

  {
    path: '',
    component: HomepageComponent
  },
  {
    path: "signup",
    component: SignupComponent
  },
  {
    path: "signin",
    component: SigninComponent
  },

  {
    path: "client",
    component: HeaderComponent
  },

  {
    path:"login", component:SigninComponent
  },


  {
    path: "modif-client/:id",
    component: ModifClientComponent
  },
  {
    path: "new-client",
    component: NewClientComponent
  },
  {
    path: "mon-cv",
    component: MonCvComponent
  },
  {
    path:"flooter",
    component:FooterComponent
  },
  {
  path:"",redirectTo:"/",pathMatch:'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
