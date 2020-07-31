import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PraicoComponent } from './praico.component';

describe('PraicoComponent', () => {
  let component: PraicoComponent;
  let fixture: ComponentFixture<PraicoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PraicoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PraicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
