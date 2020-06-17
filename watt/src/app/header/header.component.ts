import {Component, Input, OnInit} from '@angular/core';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { ChangeEvent } from '@ckeditor/ckeditor5-angular/ckeditor.component';
import {ClientService} from "../services/client.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
   public nomClient2;
  public Editor = ClassicEditor;

  public onReady( editor ) {
    editor.ui.getEditableElement().parentElement.insertBefore(
      editor.ui.view.toolbar.element,
      editor.ui.getEditableElement()
    );
  }

  constructor(private clientService:ClientService,private router:Router) { }

  ngOnInit(): void {
    this.clientService.change.subscribe(
      isClient=>{
        this.nomClient2=isClient;
      }
    )

  }

  onChange({ editor }: ChangeEvent) {
    const data = editor.getData();
    console.log( data );
  }
}
