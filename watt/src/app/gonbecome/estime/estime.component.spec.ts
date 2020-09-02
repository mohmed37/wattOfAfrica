import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstimeComponent } from './estime.component';

describe('EstimeComponent', () => {
  let component: EstimeComponent;
  let fixture: ComponentFixture<EstimeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstimeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
