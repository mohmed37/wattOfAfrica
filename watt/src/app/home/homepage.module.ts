import {HomepageRoutingModule} from "./homepage-routing.module";
import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import {HomepageComponent} from "./homepage/homepage.component";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";


@NgModule({
  declarations: [HomepageComponent],
  imports: [
    CommonModule,
    HomepageRoutingModule,
    MatIconModule,
    MatButtonModule,

  ]
})
export class HomepageModule { }
