import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FicheMetierComponent } from './fiche-metier.component';

describe('FicheMetierComponent', () => {
  let component: FicheMetierComponent;
  let fixture: ComponentFixture<FicheMetierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FicheMetierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FicheMetierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
