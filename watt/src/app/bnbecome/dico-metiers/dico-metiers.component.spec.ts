import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DicoMetiersComponent } from './dico-metiers.component';

describe('DicoMetiersComponent', () => {
  let component: DicoMetiersComponent;
  let fixture: ComponentFixture<DicoMetiersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DicoMetiersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DicoMetiersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
