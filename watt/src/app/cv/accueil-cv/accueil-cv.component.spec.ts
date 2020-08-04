import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccueilCvComponent } from './accueil-cv.component';

describe('AccueilCvComponent', () => {
  let component: AccueilCvComponent;
  let fixture: ComponentFixture<AccueilCvComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccueilCvComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccueilCvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
