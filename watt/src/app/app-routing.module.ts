import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import {NewClientComponent} from "./new-client/new-client.component";
import {ModifClientComponent} from "./modif-client/modif-client.component";
import {MonCvComponent} from "./mon-cv/mon-cv.component";


const routes: Routes = [
  {
    path: "client",
    component: HeaderComponent
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
  },{
  path:"",redirectTo:"/",pathMatch:'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
