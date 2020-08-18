import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import {NewClientComponent} from "./new-client/new-client.component";
import {ModifClientComponent} from "./modif-client/modif-client.component";
import {SignupComponent} from "./auth/signup/signup.component";
import {SigninComponent} from "./auth/signin/signin.component";
import {DefinitionComponent} from "./definition/definition.component";
import {AdministrateurComponent} from "./administrateur/administrateur.component";




const routes: Routes = [

  {

    path: 'admin',
    component: AdministrateurComponent
  },

  {
    path: 'EnSavoirPlus',
    component: DefinitionComponent
  },


  {
    path: '',
    children: [
      {path: '', redirectTo: '/home', pathMatch: 'full'},
      {
        path: 'home', loadChildren: () => import('./home/homepage.module').then(m=>m.HomepageModule)
      },
      {
        path: 'bndream', loadChildren: () => import('./bndream/bndream.module').then(m=>m.BndreamModule)
      },
      {
        path: 'bnbecome', loadChildren: () => import('./bnbecome/bnbcome.module').then(m=>m.BnbcomeModule)
      },
      {
        path: 'newCv', loadChildren: () => import('./cv/cv.module').then(m=>m.CvModule)
      }

      ]
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
    path:"flooter",
    component:FooterComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
