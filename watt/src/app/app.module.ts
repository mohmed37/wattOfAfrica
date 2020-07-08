import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import { FooterComponent } from './footer/footer.component';
import { NewClientComponent } from './new-client/new-client.component';
import { ModifClientComponent } from './modif-client/modif-client.component';
import { MonCvComponent } from './mon-cv/mon-cv.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';
import {MatInputModule} from "@angular/material/input";
import {CommonModule} from "@angular/common";
import {EditorModule} from "@progress/kendo-angular-editor";
import { LoginComponent } from './login/login.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import { HomepageComponent } from './homepage/homepage.component';
import { SignupComponent } from './auth/signup/signup.component';
import { SigninComponent } from './auth/signin/signin.component';
import { TopbarComponent } from './share/components/topbar/topbar.component';
import {LayoutModule} from "./share/layout/layout.module";
import {ClientService} from "./services/client.service";
import {LogoutComponent} from "./auth/logout/logout.component";
import {MatIconModule} from "@angular/material/icon";
import { DefinitionComponent } from './definition/definition.component';
import { BndreamComponent } from './bndream/bndream.component';
import { BndreamTestComponent } from './bndream-test/bndream-test.component';
import {MatProgressBarModule} from "@angular/material/progress-bar";
import { PhotolangageComponent } from './photolangage/photolangage.component';
import { RoueVieComponent } from './roue-vie/roue-vie.component';
import { AutoportraitComponent } from './autoportrait/autoportrait.component';
import { PraicoComponent } from './praico/praico.component';
import { HeroComponent } from './hero/hero.component';
import { AdministrateurComponent } from './administrateur/administrateur.component';
import { FicheMetierComponent } from './fiche-metier/fiche-metier.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NewClientComponent,
    ModifClientComponent,
    MonCvComponent,
    LoginComponent,
    SigninComponent,
    LogoutComponent,
    SignupComponent,
    HomepageComponent,
    DefinitionComponent,
    BndreamComponent,
    BndreamTestComponent,
    PhotolangageComponent,
    RoueVieComponent,
    AutoportraitComponent,
    PraicoComponent,
    HeroComponent,
    AdministrateurComponent,
    FicheMetierComponent

  ],
  imports: [
    CKEditorModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    CommonModule,
    EditorModule,
    FlexLayoutModule,
    LayoutModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatIconModule,
    MatProgressBarModule,
    ReactiveFormsModule

  ],
  providers: [
    ClientService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
