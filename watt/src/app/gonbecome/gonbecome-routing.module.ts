import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {AccueilGonbecomeComponent} from "./accueil-gonbecome/accueil-gonbecome.component";
import {AccueilCvComponent} from "../cv/accueil-cv/accueil-cv.component";
import {EntretienComponent} from "./entretien/entretien.component";
import {EstimeComponent} from "./estime/estime.component";
import {OrganisationComponent} from "./organisation/organisation.component";
import {OffreComponent} from "./offre/offre.component";

const routes: Routes = [
  {

    path: '',
    data: {
      breadcrumb: "gonbecome"
    },
    children: [
      {
        path: '',
        data: {
          breadcrumb: null
        },
        component: AccueilGonbecomeComponent,
      },
      {
        path: 'newCv',
        data: {
          breadcrumb: 'Cv'
        },
        children: [
          {
            path: '',
            data: {
              breadcrumb: null
            },
            component: AccueilCvComponent,
          },
        ],
      },
      {
        path: 'entretien',
        data: {
          breadcrumb: 'Réussir un entretien d’embauche '
        },
        children: [
          {
            path: '',
            data: {
              breadcrumb: null
            },
            component: EntretienComponent,
          },
        ],
      },
      {
        path: 'estime',
        data: {
          breadcrumb: 'Estime de soi'
        },
        children: [
          {
            path: '',
            data: {
              breadcrumb: null
            },
            component:EstimeComponent,
          },
        ],
      },
      {
        path: 'organisation',
        data: {
          breadcrumb: "S'organiser"
        },
        children: [
          {
            path: '',
            data: {
              breadcrumb: null
            },
            component: OrganisationComponent,
          },
        ],
      },
      {
        path: 'offre',
        data: {
          breadcrumb: 'Offre de formation'
        },
        children: [
          {
            path: '',
            data: {
              breadcrumb: null
            },
            component: OffreComponent,
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
export class GonbecomeRoutingModule{}
