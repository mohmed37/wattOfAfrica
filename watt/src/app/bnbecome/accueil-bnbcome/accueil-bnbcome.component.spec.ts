import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccueilBnbcomeComponent } from './accueil-bnbcome.component';

describe('AccueilBnbcomeComponent', () => {
  let component: AccueilBnbcomeComponent;
  let fixture: ComponentFixture<AccueilBnbcomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccueilBnbcomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccueilBnbcomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
