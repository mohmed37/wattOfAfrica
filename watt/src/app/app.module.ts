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
    SignupComponent

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
    ReactiveFormsModule

  ],
  providers: [
    ClientService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }