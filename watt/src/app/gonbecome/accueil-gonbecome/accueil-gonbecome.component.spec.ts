import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccueilGonbecomeComponent } from './accueil-gonbecome.component';

describe('AccueilGonbecomeComponent', () => {
  let component: AccueilGonbecomeComponent;
  let fixture: ComponentFixture<AccueilGonbecomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccueilGonbecomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccueilGonbecomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
