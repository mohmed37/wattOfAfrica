import {HomepageRoutingModule} from "./homepage-routing.module";
import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import {HomepageComponent} from "./homepage/homepage.component";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import { ContactComponent } from './contact/contact.component';
import {ReactiveFormsModule} from "@angular/forms";
import {LayoutModule} from "../share/layout/layout.module";


@NgModule({
  declarations: [HomepageComponent, ContactComponent],
  imports: [
    CommonModule,
    HomepageRoutingModule,
    MatIconModule,
    MatButtonModule,
    ReactiveFormsModule,
    LayoutModule,

  ]
})
export class HomepageModule { }
