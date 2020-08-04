import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {CKEditorModule} from "@ckeditor/ckeditor5-angular";
import {ChartsModule} from "ng2-charts";
import {ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatRadioModule} from "@angular/material/radio";
import {MatInputModule} from "@angular/material/input";
import {Ng2PageScrollModule} from "ng2-page-scroll";
import {DicoMetiersComponent} from "./dico-metiers/dico-metiers.component";
import {ProjetProComponent} from "./projet-pro/projet-pro.component";
import {PortefolioComponent} from "./portefolio/portefolio.component";
import {ProfilUComponent} from "./profil-u/profil-u.component";
import {BnbcomeRoutingModule} from "./bnbcome-routing.module";

@NgModule({
  declarations: [DicoMetiersComponent,ProjetProComponent,PortefolioComponent,ProfilUComponent],
  imports: [
    CommonModule,
    BnbcomeRoutingModule,
    CKEditorModule,
    ChartsModule,
    ReactiveFormsModule,
    MatIconModule,
    MatButtonModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatRadioModule,
    MatInputModule,
    Ng2PageScrollModule
  ]
})
export class BnbcomeModule{}
