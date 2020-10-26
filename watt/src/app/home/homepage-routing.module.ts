import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomepageComponent} from "./homepage/homepage.component";
import {AccueilBnbcomeComponent} from "../bnbecome/accueil-bnbcome/accueil-bnbcome.component";
import {DicoMetiersComponent} from "../bnbecome/dico-metiers/dico-metiers.component";
import {ContactComponent} from "./contact/contact.component";

const routes: Routes = [
  {
    path: '',
    data: {
      breadcrumb: 'Home'
    },
    children: [
      {
        path: '',
        data: {
          breadcrumb: null
        },
        component: HomepageComponent,
      },
      {
        path: 'contact',
        data: {
          breadcrumb: 'Etablir le contact'
        },
        children: [
          {
            path: '',
            data: {
              breadcrumb: null
            },
            component: ContactComponent,
          },
        ],
      },
    ]
  }
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomepageRoutingModule {
}
