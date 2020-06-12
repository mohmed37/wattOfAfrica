import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import {FormsModule} from "@angular/forms";
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

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NewClientComponent,
    ModifClientComponent,
    MonCvComponent,

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

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
